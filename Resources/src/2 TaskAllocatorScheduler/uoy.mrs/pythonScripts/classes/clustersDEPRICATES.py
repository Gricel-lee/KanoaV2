import auxiliary 
import os
from numpy.random.mtrand import permutation
import itertools
import math

class Clusteri():
    
    def __init__(self,p,a,num_cluster):
        #problem
        self.p = p
        # allocation
        self.a = a
        # list of robots in the i cluster of allocation a
        self.cluster = a.robotclusters[num_cluster] # robots in cluster
        # robot classes
        self.robotClasses = self.getRobotsInstances(p);
        
        self.uniqueID_alloc_clust = str(a.num)+"_"+str(num_cluster)# new file
        #pm file
        #self.filepm = os.path.abspath(p.path_evo + "/"+self.uniqueID_alloc_clust+"PM"+".pm")
        #props file
        self.fileprops = os.path.abspath(p.path_evo + "/"+self.uniqueID_alloc_clust+"PM"+".props")
        
        # robot and tasks array
        self.perm_robot_task = self.permutationsArray()
        
    def nameFilePMProps(self,perm,extension):
        '''MDP file based on the permutation
        extension = props or pm
        '''
        s = ""
        for i in perm:
            s += str(i);
        return os.path.abspath(self.p.path_evo + "/"+self.uniqueID_alloc_clust+"PM"+s+"."+extension)
        
    
    def permutationsArray(self):
        ''' Array of all permutations
        example:
        r3 = [t1,t2]      , num_tasks[r1]=2
        r2 = [t1,t2,t3]   , num_tasks[r2]=3
        
        perm:    meaning:?    
        r3 r2    r3    r2
        [0,0]    t1t2    t1t2t3
        [0,1]    t1t2    t1t3t2
        [0,2]    t1t2    t2t1t3
        [1,0]    t2t1    t2t3t1
        [1,1]    t2t1    t3t1t2
        [1,2]    t2t1    t3t2t1
        
        Notice that the order of the tasks in the
        permutation array and 
        the order of the robots matter
        '''
        num_tasks={}
        for r in self.cluster:
            #print("robot ",r)
            nt = len(self.a.get_rtasks(r))
            num_tasks[r] = math.factorial(nt)  #  factorial as if a robot has 3 tasks, then: [t1,t2,t3],[t1,t3,t2],[t2,t1,t3]...
        
        #print("tasks",num_tasks)
        r_index_tasks = []
        for ntasks in num_tasks.values():
            x = list(range(0,ntasks))
            r_index_tasks.append(x)
        #print(r_index_tasks)
        permutations = list(itertools.product(*r_index_tasks))
        #print("perm",permutations)
        
            
         
        if self.p.nPermut != -1:
            if len(permutations)<=self.p.nPermut:
                return permutations
            else:
                return permutations[:self.p.nPermut]
            print('see here',permutations)
        return permutations
        
            
    
    def tasksinPermutation(self,r,perm,a): # depends on perm_robot_task
        # get index of robot (index is the column of the permutation)
        # e.g. [r5,r3,r6] = perm=(X,0,1), means that r5 has permutation of tasks a.get_nPermutations(r,p)[X]
        ri = self.cluster.index(r) # index of the robot i
        #perm_i = self.permutationsArray.index(perm) #e.g., if perm=(0, 2), index=2 in array: [(0, 0), (0, 1), (0, 2), (0, 3), (1, 0), (1, 1), (1, 2), (1, 3)]
        n = perm[ri] # nth permutation of robot i
        tasks = self._get_nPermutations(r, self.p)[n]
        return tasks
    
    
    def _get_nPermutations(self,r,p):
        '''Get N permutation of tasks.
        n=-1 means all permutations
        
        use by class: "cluster"
        '''
        n = p.nPermut
        tasks = self.a.get_rtasks(r)
        tasksPerm = list(itertools.permutations(tasks))
        if n==-1:   # return all
            return tasksPerm
        if len(tasksPerm)>n: # return n required 
            return tasksPerm[0:n]
        else:       # return all possible as can't complete n required
            return tasksPerm
    
    
    def get_rTravellingDistance(self,r,perm,a):
        '''Get total travelling distance of a robot 
        for a specific permutation of tasks
        '''
        dist = 0
        tasksList = self.tasksinPermutation(r,perm,a)
        
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
            