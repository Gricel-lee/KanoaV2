'''
Allocation class.
- tasks tree
- tasks allocation
- clusters of robots (transitive closure)
    
Author: Gricel Vazquez 22/05/2022
'''
import auxiliary.utility
import auxiliary.allocationInfo
import auxiliary.tc
import os
from auxiliary.utility import isJoin
from classes.constrainedTask import ConstrainedTask

import pandas as pd

class Allocation():
    
    def __init__(self,p,fileAlloy):
        
        self.fileAlloy = fileAlloy # file of alloy allocation
        #Num,e.g.: Allocation1
        self.num = auxiliary.utility.getNum_Alloyfile(fileAlloy) # number of alloy allocation
        
        self.dfAllocation = auxiliary.allocationInfo.getAlloyAllocation(p.fileMissionTree,fileAlloy) # get dataframe with task allocation
        
        #print(self.dfAllocation)
        
        #clusters, e.g.: [['r5', 'r3', 'r2'] , ['r1', 'r4']]'''
        self.robotclusters = auxiliary.tc.get_transitive_closure(self.dfAllocation,p.dfTasks)     
        #all robots in this allocation
        self.allrobotsIDs = self._getAllRobotsInAlloc()
        # list of all ordered tasks instances
        self.orderedTasks = self._getConstrainedTasksInstances(False,True)
        
        
        #DEPRICATED
        # dictionary with robots and its genes values, aka, num of permutation.
        # needed for MDP
        #self.permutationArray = {}
        
        
        #DEPRICATED
        #initialise array with indexes of unique clusters-allocation (among all allocations)
        #self.num_unique_cluster = []
        
        #DEPRICATED
        #self.allPermutations = []
        
         
        # print(" Fetching allocation: ", self.num)
        
        #printIt2(self.dfAllocation)
        '''self.dfAllocation - contains allocation info, e.g.:
               id parent    ordered_children        runbyrobot  joint ordered consecutive   location
        0    t4$0     NA           ['ct2$0']               NaN  NaN     NaN         NaN     NaN
        1    t2$0     NA           ['ct1$2']               NaN  NaN     NaN         NaN     NaN
        2    t3$0     NA           ['at3$0']               NaN  NaN     NaN         NaN     NaN
        3    t1$0     NA           ['ct1$1']               NaN  NaN     NaN         NaN     NaN
        4   ct2$0   t4$0  ['at4$0', 'ct1$0']               NaN  NaN     True        True    NaN
        5   ct1$2   t2$0  ['at1$0', 'at2$0']               NaN  NaN     False       True    NaN
        6   at3$0   t3$0                 NaN  ['r4$0', 'r3$0']  True    NaN         NaN     l9
        7   ct1$1   t1$0  ['at1$1', 'at2$1']               NaN  NaN     False       True    NaN
        8   at4$0  ct2$0                 NaN          ['r2$0']  NaN     NaN         NaN     l10
        9   at2$2  ct1$0                 NaN          ['r2$0']  NaN    True         True    l13
        10  at1$2  ct1$0                 NaN          ['r2$0']  NaN     NaN         NaN     l9...
        '''
    
    
    # Depricated
    '''def setPermArray(self,genesRob,genesVal):
        #Robot ID to number of permutation of tasks
        perm = {}
        for r,val in zip(genesRob,genesVal):
            perm[r] = val
        self.permutationArray = perm
    '''
    
    def getloctask(self,at):
        '''Get location of an atomic task'''
        df = self.dfAllocation
        return df[df['id']==at]['location'].values.item()
    
    

    
    def _getConstrainedTasksInstances(self,consecutive,ordered):
        # Note. re-done, second time
        '''Get compound tasks consec/order constrained
        input combinations: (not) ordered / (not) consecutive, e.g.: 
        consecutive = False      #must be ==True/False otherwise detects NaN as well
        ordered = True           #must be ==True/False otherwise detects NaN as well
        '''
        dfAllocation = self.dfAllocation
        # filter tasks
        df = dfAllocation.loc[dfAllocation['consecutive']==consecutive] 
        df = df.loc[df['ordered']==ordered]
        df = df.loc[df['joint'].isnull()] # For further refinement: this is added as there is an error in the generation of atomic tasks in the allocationInfo.csv file. They contain info in columns: consecutive and ordered
        
        lst = []
        for i in df.to_dict(orient='records'):
            lst.append(ConstrainedTask(self,i))
        return lst
    
        
    
    def isAtomic(self,t):
        '''Check if t is atomic task'''
        try:
            df = self.dfAllocation
            return pd.notnull( df.loc[df['id']==t,'runbyrobot'].values.item() )
        # ERROR handling
        except Exception as e: 
            print("ERROR: ", e) 
            print("\nERROR: "+t+" possibly repeated in allocation info.\nCheck resources/dslmodel/src-gen/modelMissionsTree.txt.")
                

    def isAtomicPartOfOrdered(self,at):
        '''Returns True if the atomic task and
        the higher task with an order constrained
        from the tasks tree the atomic task is
        part of.
        
        (I.e., ordered task with more atomic tasks from where at is part of.)
        
         e.g. Task tree:
                   ct1
               ct2     at4
            at1   ct3
                at2 at3
        if all ct are ordered, return ct1, as it has more atomic tasks children
            
        '''
        # get all ordered tasks from which atomic task is part of
        part_of = []
        for ordered in self.orderedTasks:
            #print("Checking if ordered:",at," in:", ordered.idInAllocation)
            #print("with list atomic tasks: ",ordered.atomicChildren)
            
            for t in ordered.atomicChildren:
                if t ==at:
                    part_of.append(ordered)
        # if at is not ordered
        if part_of == []:
            return False, False
        elif len(part_of)==1:
            return True,part_of[0]
        else:
            # check parent ordered task (meaning ordered task with
            #more atomic tasks, and return ordered task
            # e.g. Task tree:
            #       ct1
            #  ct2     at4
            #at1   ct3
            #    at2at3
            #if all ct are ordered, return ct1, as it has more atomic tasks children
            ctWithmaxNumat = part_of[0] # parent of the "ordered tree"
            for i in range (1,len(part_of)):
                if ctWithmaxNumat.num_atomicChildren < part_of[i].num_atomicChildren:
                    ctWithmaxNumat = part_of[1]
            return True, ctWithmaxNumat
    
    
    def get_task_generic(self,t):
        '''e.g:
            at1_move_0 ->   at1_move
        '''
        return t.rsplit('_',1)[0]
    
    
    
    def saveAllocation_n_TCInfo(self, path_tc):
        '''Safe allocation and transitive closure information if save_data="True" '''
        
        ''' HERE IS THE INFO FOR ALLOCATION
        # - save allocation   print(path_tc)
        self.dfAllocation.to_csv(path_tc + self.num + "AllocationInfo.csv")
        '''
        # - save transitive closure
        s = ""
        
        with open(os.path.abspath(path_tc + self.num + 'TransClosure.txt'), 'w') as f:
            for item in self.robotclusters:
                s += "%s\n" % item
            f.write(s[:-1])
            
                
            #printIt2('Allocation: \"'+ a.fileAlloy)
            #print("saved in: \""+ path_tc + a.num)
            #print(a.num + 'Transitive closure Done. \n  Allocation: \"'+ fileAlloy + "\"  saved in: \""+ path_tc + num + 'Transitive_closure_clusters.txt\"')
        return
    
    def getNumRobots(self):
        return len(self.allrobotsIDs)
    
    def getNumClusters(self):
        return len(self.robotclusters)
    
    
    
    
    def _getAllRobotsInAlloc(self):
        allrobots = set()
        for r in self.robotclusters:
            allrobots.update(r)
        #print(allrobots)
        return allrobots
    
    
    
    
    
    # modified for each allocation
    #tasks = []
    #self.tasksLocations = []
    #self.r_locations = []
    #num_locations = ""
    #loc_to_tasks = []
    
    

    
    
    def robot_allocation(self,r):
        '''Modifiable for each allocation'''
        #locations of these tasks
        #tasks, tasksLocations= self.get_rtasks(r)
        # unique locations to visit of robot r
        #r_locations = list(dict.fromkeys(tasksLocations))
        # num of locations to visit
        #num_locations = len(set(tasksLocations))
        # locations to visit for robot r, to tasks
        loc_to_tasks = self._r_task_in_location(self.r_locations,self.tasks,self.tasksLocations)
        
        return loc_to_tasks
        
    
    
    def _r_task_in_location(self,r_locations,tasks,tasksLocations):
        '''Dictionary of locations to tasks done in that location'''
        loc_to_tasks = {}
        for i in r_locations:
            tasks_in_i = [] # save tasks in location i
            for loc_i,count in zip(tasksLocations,range(len(tasksLocations))):
                if i==loc_i:

                    tasks_in_i.append(tasks[count]) #this is possible as tasks and tasksLocations is a one to one relation, e.g. [Room1,Room2]->[at1,at2]
            # add to loc dictionary
            loc_to_tasks[i] = tasks_in_i

        return(loc_to_tasks)
    
    
    def getrobotsSharingJoinTask(self,at):
        robots = []
        for r in self.allrobotsIDs:
            tasks = self.get_rtasks_FromDatabase(r)
            if at in tasks:
                robots.append(r)
        return robots
    
    
    def get_rtasks_FromDatabase(self,r):
        '''Tasks allocated to robot r'''
        df = self.dfAllocation
        # (needed to look for robot)
        d1 = df[df['runbyrobot'].apply(lambda x: isinstance(x, str))] #rows that have "runbyrobot" (i.e., str type in df)
        r1 = "\'"+r+"\'" #add quotations to look for robot in string, JIC
        row_index_with_r =[] #df rows with robot r

        # look for specific robot r
        for i,count in zip(d1['runbyrobot'],d1.index):
            #print(count,"  ",i,type(i),i[1])
            if r1 in i:
                row_index_with_r.append(count)
        df_r = df.iloc[row_index_with_r]
        #print('robot ',r1, ' in ',df_r)
        tasks, locations = [],[]
        for i,iloc in zip(df_r['id'],df_r['location']):
            tasks.append(i) #only list of tasks
            locations.append(iloc)
        #print("Tasks of "+r+": "+str(tasks))
        #print("Tasks renamed of "+r1+": "+str(tasks_rename)) #replaced "'" and "$"
        return(tasks)#,locations)
    
    '''The next functions are related to a robot in the allocation'''
    ''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''''
    
    
    def get_rnumJoinTasks(self,r,r_permutation):
        '''Number of 'join' tasks allocated to robot r'''
        num = 0
        for t in r_permutation.tasks: #robot_classes_i[r].tasks:
            if isJoin(self.dfAllocation,t):
                num+=1
        return num
    
    def get_rnumStates(self,r,r_permutation):
        '''Number of states needed for module
        = num of tasks
        + num of joint tasks
        + 1 (to get travelling cost reward)
        '''
        return len(r_permutation.tasks) + self.get_rnumJoinTasks(r,r_permutation) + 1
        
    
    
    
    def get_rLocationsToVisit(self,r,p,tasksList):
        '''Get list of locations to visit from initial robot location
        through its allocated tasks'''
        initloc = p.robot_classes[r].init_loc   # initial location of robot r
        visitLoc = [initloc]
        for at in tasksList:
            visitLoc.append(self.getloctask(at))
        return visitLoc
    