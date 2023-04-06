import auxiliary 
import os
from numpy.random.mtrand import permutation
import itertools
import math

class Cluster():
    
    def __init__(self,p,a,num_cluster,perm_num):
        #problem
        self.p = p
        # allocation
        self.a = a
        # list of robots
        self.cluster = a.robotclusters[num_cluster]
        # robot classes
        self.robotClasses = self.getRobotsInstances(p);
        
        self.num_cluster = num_cluster # number associated to list of clusters on the allocation
        # 
        self.ID_alloc_clust = str(a.num)+"_"+str(perm_num)+"_"+str(self.num_cluster)# new file
        #pm file
        self.filepm = os.path.abspath(p.path_mdp + "/"+self.ID_alloc_clust+".pm")
        #props file
        #self.fileprops = os.path.abspath(p.path_mdp + "/"+self.ID_alloc_clust+"PM"+".props")
        # robot and tasks array
        
        #dictionary: robotPermutation[r] = Permutation(p,a,r,genesVal)
        self.robotPermutations = {}
        
        self.perm_num = perm_num
        
        
    def nameFileMDP(self,extension):
        ''' MODIFIED
        MDP file based on the permutation extension = props or pm
        '''
        return os.path.abspath(self.p.path_mdp + "/"+self.ID_alloc_clust+"."+extension)
        
    
    
    def get_rTravellingDistance(self,r,a,tasksList):
        '''Get total travelling distance of a robot 
        for a specific permutation of tasks
        '''
        dist = 0
        
        visitLoc = a.get_rLocationsToVisit(r,self.p,tasksList)
        for i in range (0,len(visitLoc)-1):
            if visitLoc[i] != visitLoc[i+1]: # if same location, distance is 0. If not, add it:
                dist = dist + math. ceil(float (self.p.worldModel.get_dist_loc1loc2(visitLoc[i] , visitLoc[i+1]) ))
        
        return dist
    
    
    def getRobotsInstances(self,p):
        ''' Robots on cluster i'''
        try:
            robot_classes_i ={}
            for r in self.cluster: # all robots in cluster
                #print(r, p.robot_classes.keys())
                robot_classes_i[r] = p.robot_classes[r]
            return robot_classes_i
        # ERROR
        except Exception as e:
            print("\nERROR: Check that all robots in DSL are in resources/dslmodel/src-gen/modelAllocation.als and vice versa.")
            print(e)
            