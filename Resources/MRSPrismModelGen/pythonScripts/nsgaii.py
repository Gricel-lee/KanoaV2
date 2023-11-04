from pymoo.optimize import minimize

from pymoo.core.problem import Problem
#from pymoo.model.problem import Problem

import numpy as np
import math
from functools import reduce# multiply elements in a list
import operator
import random
import itertools
import subprocess
import re
from pymoo.visualization.scatter import Scatter

from pymoo.algorithms.moo.nsga2 import NSGA2

from pymoo.factory import get_sampling, get_crossover, get_mutation

from pymoo.operators.mixed_variable_operator import MixedVariableSampling, MixedVariableMutation, MixedVariableCrossover
    
    
from classes.robotSchedule import RobotSchedule
from classes.cluster import Cluster 
import evoFiles.evoFile2



'''-------------------------------------------------------'''
class runNSGA2():
    
    def __init__(self,p,a):
        # 1) set problem to solve
        self.problem = self.getProblem(a,p)
        # 2) set algorithm (evolving only integer gene values)
        self.algorithm = self.getAlgorithm(a)
        # 3) get results
        self.res = minimize( # Get pymoo NSGAII results
            problem=self.problem,
            algorithm=self.algorithm,
            termination= ('n_gen', 10) #number of generations
            ,seed=1 #Run NSGAII, always the same if seed!=null
            ,verbose=False
            #save_history=True
            )
        
        
    def getProblem(self,a,p):
        
        return MRS_PRISM_Problem( # num variables, num of objectives, lower, upper bound
            n_var=a.getNumRobots(), # number of genes is the number of robots in ith allocation
            n_obj=3,
            n_constr=0, 
            xl= [0]*len(a.allrobotsIDs), # lower value for each of the genes (0) # e.g. [0,0,0,...]
            xu= self._getGenesLimit(a,10),
            allocation = a,
            problem = p) # added to pass schedule info
        #print(rob)
        #print('low',xl)
        #print('up',xu)
    
    def _getGenesLimit(self,a,boundPerm):
        # upper limit for  each gene = number of permutations for each of the robots -1
        xu = []  #'''Note: upper and lower limit can't be the same? If it is the same it means it is already 'optimised' (single solution). '''
        for r in a.allrobotsIDs:
            #rob.append(r)
            n_permutations = math.factorial(len(a.get_rtasks(r)))
            
            bound_perm = True
            if bound_perm:
                if n_permutations > boundPerm:
                    n_permutations = boundPerm
            
            xu.append(n_permutations-1)  # =[3,5,10,..] number of permutations, starts
            print('r',r,' has ',a.get_rtasks(r), ' perm')
        return xu
    
    def getAlgorithm(self,a):
        mask = ['int']*a.getNumRobots() # 3 genes (robots) and all are integers (num of permutation of tasks). Modify to evolve genes as integers (not reals)
        return NSGA2(pop_size=20,     # algorithm for pymoo
                sampling = MixedVariableSampling(mask, {"int": get_sampling("int_random")}),
                crossover= MixedVariableCrossover(mask, {"int": get_crossover("int_sbx", prob=1.0, eta=3.0)}),
                mutation = MixedVariableMutation(mask, {"int": get_mutation("int_pm", eta=3.0)}),
                eliminate_duplicates=True,) # population
    
     
    
    def plotIt(self):
        plot = Scatter()
        plot.add(self.problem.pareto_front(), plot_type="line", color="black", alpha=0.7)
        plot.add(self.res.F, facecolor="none", edgecolor="red")
        plot.show()
        
        
    def printResults(self):
        print("Best solution found: %s" % self.res.X)
        print("Function value: %s" % self.res.F)
        print("Best solution found: \nX = %s\nF = %s" % (self.res.X, self.res.F))
        
        #print("Constraint violation: %s" % res.CV)
        
        
        #Example, 1 robot in allocation with three tasks: ['at4_notify_0', 'at2_floor_1', 'at3_sanit_2']
        #- low gene value = [0]
        #- up gene value  = [5] (factorial of tasks - 1, as starts in 0)
        
'''-------------------------------------------------------'''
class MRS_PRISM_Problem(Problem):
    
    #use for NSGA2 pymoo
    def _evaluate(self,chromosomes,out,*args,**kwargs):
        '''Evaluate chromosomes'''
        print('Evaluate chromosomes')
        res = [] # this is a list of lists. Each sublist represent the resulting values of a chromosome. Needed for pymoo.
        a = self.a # allocation variable added to Problem class already
        p = self.p
        
        
        fp = open('checkWhere.txt','w')
        fp.write('Chromosomes:'+str(chromosomes))
        # a) get chromosome to evaluate
        for chromosome in chromosomes: #chromosomes = e.g. [[1 0] [0 0]], #chromosome: [0,0] - permutation of individual robots
            fp.write(str(chromosome))
            
            idle = []
            travel = []
            prob_succ = []
            
            
            fp.write('\n Chromosome:'+str(chromosome))
            
            for robots in a.robotclusters:
                # c.1 get list gene values for cluster
                genes = self.getRobotsGenesValues(robots,chromosome)
                
                print(a.robotclusters)
                
                # c.2 create cluster
                c = Cluster(p,a,robots,genes)
                
                # d) get values 
                # d.2 create MDP
                pmFile,totalTravel = evoFiles.evoFile2.create_MDP_file(a,p,c,genes) #"/Users/gris/eclipse-workspace/uoy.mrs/tests/Example3/models/EvoModels/1_0PM01.mdp"
                # d.3 create props
                f1Feas,f2P,f3I,f4T=evoFiles.evoProperties.create_PROP_file(c,a)
                # d.4 PRISM
                prism = "/Users/gris/Documents/prism-4.7-osx64/bin/prism"
                
                #path = "/Users/gris/eclipse-workspace/uoy.mrs/tests/Example3/models/EvoModels"
                #f1Feas = "/Users/gris/eclipse-workspace/uoy.mrs/resources/pythonScripts/checkIfPossible.props" #-pf \"Pmax=?[F done]\
                
                
                # d.4.1 run prism: check if schedulable
                outputFeas = subprocess.Popen([prism, pmFile,f1Feas], stdout=subprocess.PIPE).stdout.read().strip().decode("utf-8")
                isSchedulable = float(re.search('Result: (\-?\d*\.?\d*)', outputFeas).group(1))
                
                if isSchedulable == 0:
                    
                    idle.append(99999999999999)
                    travel.append(99999999999999)
                    prob_succ.append(9999999999999999)
                else:
                    
                    # idle
                    '''output = subprocess.Popen([prism, pmFile,f3I], stdout=subprocess.PIPE).stdout.read().strip().decode("utf-8")
                    resultI = float(re.search('Result: (\-?\d*\.?\d*)', output).group(1))'''
                    idle.append(1)
                    # travel
                    travel.append(totalTravel)
                    # prob
                    prob = 1
                    for r in robots:
                        rTasks = a.get_rtasks(r)
                        print(r+'ROBOT HAS TASKS ',rTasks)
                        for t in rTasks:
                            print('prob: ',p.robot_classes[r].getProb4Task(t))
                            prob = 0.5#prob * p.robot_classes[r].getProb4Task(t)
                            
                    
                    '''output = subprocess.Popen([prism, pmFile,f2P], stdout=subprocess.PIPE).stdout.read().strip().decode("utf-8")
                    resultP= float(re.search('Result: (\-?\d*\.?\d*)', output).group(1))
                    prob_succ.append(resultP)'''
                    prob_succ.append(prob)
                    
                
                # if I want to print prism output
                printIt = True
                if printIt:
                    #print("GENES",genes)
                    print(str(outputFeas)) # PRINT PRISM
                    print('Result:',isSchedulable)
                    print('idle',idle[-1])
                    print('travel',travel[-1])
                    print('prob_succ',prob_succ[-1])
                
                
                # another way of running cmd command:
                #a = subprocess.call([prism, pmFile,f1])
                #print("RESULT1",a,pmFile)
                
                
                # b.1 modify cluster to only have one permutation of tasks (JIC, but passed directly in as perm)
                #print('PERM:',perm)
                
            # save chromosome results
            res.append( [sum(idle),sum(travel),reduce(operator.mul, prob_succ, 1)] )
            
            fp.write('Chromosome values:'+str([sum(idle),sum(travel),reduce(operator.mul, prob_succ, 1)]))
            
        #print(res)
        
        # SAVE RESULTS by:
        fp.close()
        out['F'] =np.array(res)
        
    

    
    def getRobotsGenesValues(self,robots,chromosome):
        robot_gv = self._getGeneValue(chromosome) # ALL robot genes
        rgv = [] # robots' genes values in list
        for r in robots:
            rgv.append(robot_gv[r])
        return rgv 
    
    def _getGeneValue(self,chromosome):
        robot_geneValue = {}
        for r,npermut  in zip(self.a.allrobotsIDs , chromosome):
            robot_geneValue[r] = npermut
        return robot_geneValue

    
    
    
    # update NSGAII for integers  (https://pymoo.org/customization/mixed.html)
    
    '''for chromosome in chromosomes: #chromosomes = e.g. [[1 0] [0 0]], #chromosome: [0,0] - permutation of individual robots
    robotSchedulesClasses = {}
    for r,num in zip(self.allocation.allrobotsIDs,chromosome):  # e.g., r1,  numPerm=3
        # array of robots and their scheduled tasks
        robotSchedulesClasses[r] = RobotSchedule(self.allocation,r,num)
    print(robotSchedulesClasses)
        '''
    
    
    
