import sys
import pandas as pd
import random


class tasksBeforeATs():
    
    def __init__(self,missionTreeFile):
        self.p = problem(missionTreeFile)
        
        self.tasksBeforeAT = self.tasksBefore_atomicTasks()
        
        self.saveTasksBeforeAT = self.save(missionTreeFile)
    
    
    def save(self,missionTreeFile):
        # temporary file with tasks to be done before atomic tasks part of ordered compound tasks in higher nodes
        file = missionTreeFile+"constraints"
        with open(file,'w') as f:
            f.write(str(self.tasksBeforeAT))
        #print(self.tasksBeforeAT)
        
        
    def tasksBefore_atomicTasks(self):
        ''' Get tasks to be done before atomic tasks given ordered constraints of tasks above
        e.g.: {'at1_move_0': set(), 'at1_move_1': set(), 'at4_notify_2': set(), 'at2_floor_3': {'at4_notify_2'}, 'at3_sanit_4': {'at2_floor_3', 'at4_notify_2'}, 'at4_notify_5': set(), 'at2_floor_6': {'at4_notify_5'}, 'at3_sanit_7': {'at2_floor_6', 'at4_notify_5'}, 'at4_notify_8': set(), 'at2_floor_9': {'at4_notify_8'}, 'at3_sanit_10': {'at2_floor_9', 'at4_notify_8'}, 'at4_notify_11': set(), 'at2_floor_12': {'at4_notify_11'}, 'at3_sanit_13': {'at2_floor_12', 'at4_notify_11'}}
        '''
        p = self.p
        t_before = {}
                
        for at_i in p.at.keys():
            l = self.getTasksBefore(at_i,at_i)
            t_before[at_i] = list(set(l))
            #print("FOR AT: {} has to do before: {}".format(at_i, t_before[at_i]))
        return t_before
        
    def get_all_atomic_tasks_from_CT(self,ct,task):
        '''Get children tasks from right to left until reaching task'''
        
        p = self.p
        tasksBefore = []
        stack = [ct,task] # put task at the end
        
        while stack: # while nodes to visit and not at_i reached
            nextNode = stack.pop(0)
            
            # if compound task
            if nextNode == task:
                return tasksBefore
            
            elif p.isCompound(nextNode):
                children = p.ct[nextNode].ordered_children
                
                stack = children + stack # DEEP FIRST
            
            elif p.isAtomic(nextNode):
                tasksBefore.append(nextNode)
        return []
    
    def getTasksBefore(self,task,at_i):
        ''' Get tasks to be done before, given ordering constraints'''
        p = self.p
        parent = p.allInstances[task].parent
    
        # a) if compound task
        if p.isCompound(parent):
            tasksBefore = []
            # if ordered
            if p.ct[parent].ordered:
                tasksBefore += self.get_all_atomic_tasks_from_CT(parent , task)# concat. new list
            # continue with next parent getting constraints
            tasksBefore += self.getTasksBefore(parent , at_i)
            #print("    --- finished for ct {}, tasks before:".format(at_i,tasksBefore))
            return tasksBefore
        # b) if a mission - done
        elif p.isMission(parent):
            return []
        else:
            print("ERROR, atomic task found in not a leave node. Check this.")
            
     

class mission():
    def __init__(self,name,children):
        self.id = name
        self.ordered_children = children
   
class atomic():
    def __init__(self,name,atype,parent,loc,joint):
        self.id = name
        self.type = atype
        self.parent = parent
        self.loc = loc
        self.joint = joint
  
class compound():
    def __init__(self,name,atype,parent,children,order,cons):
        self.id = name
        self.type = atype
        self.parent = parent
        self.ordered_children = children
        self.ordered = order
        self.cons = cons


class allocationsPermutations():
    def __init__(self,missionTreeFile,permutationsFile,allAllocFile):
        
        # initialise variables
        self.missionTreeFile = missionTreeFile # e.g.: "/Users/gris/eclipse-workspace/uoy.mrs/TestCase3-var4/dslmodel/src-gen/modelMissionsTree.txt"
        
        self.permutationsFile = permutationsFile # e.g. "/Users/gris/eclipse-workspace/uoy.mrs/TestCase3-var4/results/permutations.csv"
        
        self.dfA = pd.read_csv(allAllocFile) # e.g.: "/Users/gris/eclipse-workspace/uoy.mrs/TestCase3-var4/results/AllAllocations.csv"
        
        
        # DATABASE
        self.db = {}
        
        # get allocations id's
        allocIDs = self.dfA.allocid.unique().tolist()
        
        # remove repeated allocations
        allocIDs = self._removeAllocRepeated(allocIDs)
        
        
        
        
        f = open(self.permutationsFile, "w")
        f.write("allocation,,num_perm,,robot,,permutation")
        for aID in allocIDs:
            # get robots assigned to tasks data
            task_to_rTask , robots = self._task_to_robotTask(aID)
            
            
            
            # get N perm.
            N = 10 # number of perm
            dbPerm = self.getNPerm(N, task_to_rTask , robots)
            # for each permutation
            n_perm = 0
            
            
            for perm in dbPerm.values():
                # for each robot
                for r in perm.keys():
                    tasks = perm[r]
                    f.write("\n"+aID+",," + str(n_perm) + ",,"  +r+",,\""+str(tasks)+"\"")
                n_perm+=1
        f.close()
        
        #print("Done")
        
    
    def _removeAllocRepeated(self , allocIDs):
        '''This removes allocations repeated by Alloy.
        Note. This are identical allocations, so not needed.'''
        uniqueIDs = []
        for aID in allocIDs:
            dfB = self.dfA.loc[(self.dfA['allocid']==aID) & (self.dfA["uniqueAlloc"].notna())]
            if not dfB.uniqueAlloc.empty:
                uniqueIDs.append(aID)
        return uniqueIDs
    
        
    
    def getNPerm(self , N  , task_to_rTask , robots):
        tries = 10 # number of tries to get a not seen permutation
        db_counter = 0 # count if already in db
        db = {} # permutations found (keys are unique strings to assess if they are unique
        
        while len(db)<N and db_counter<tries:
            # a) get new permutation of tasks
            pr = problem(self.missionTreeFile)
            resultTaskList = pr.getFeasibleTaskPerm() # compute perm. of tasks
            # b) add robots (to check if unique for allocation i)
            resultTaskList , r_to_Permtasks, s = self.addRobotsToresultTaskList(resultTaskList, task_to_rTask , robots)
            # c) if permutation already exists, increase termination counter
            if s in db.keys():
                db_counter +=1
            else: # if not exists add it
                db[s] = r_to_Permtasks
        return db
    
    
    def addRobotsToresultTaskList(self,resultTaskList, task_to_rTask , robots):
                
        r_to_Permtasks = {key: [] for key in robots} # robots dictionary with empty list as values
        
        for i in range(0,len(resultTaskList)):
            task = resultTaskList[i]
            r_tasks = task_to_rTask[task]
            for r_t in r_tasks: # more than one means join task
                robot = r_t.split("_",1)[0]
                r_to_Permtasks[robot].append(r_t)
        # make string to check if permutation exists
        s = ""
        for r in robots: # order tasks by robots appearing in "robots" to compare among other permuations
            s += str(r_to_Permtasks[r])
        return resultTaskList , r_to_Permtasks, s
        
    
    def _task_to_robotTask(self , allocID):
        '''Get dictionary of tasks to tasks with robots
        e.g.: {'at1_move_0': 'r5_at1_move_0', 'at1_move_1': 'r4_at1_move_1', 'at3_sanit_13': 'r1_at3_sanit_13', 'at2_floor_9': 'r1_at2_floor_9', 'at3_sanit_10': 'r1_at3_sanit_10', 'at3_sanit_4': 'r2_at3_sanit_4', 'at2_floor_6': 'r1_at2_floor_6', 'at2_floor_12': 'r1_at2_floor_12', 'at4_notify_8': 'r1_at4_notify_8', 'at4_notify_11': 'r2_at4_notify_11', 'at2_floor_3': 'r2_at2_floor_3', 'at4_notify_2': 'r1_at4_notify_2', 'at3_sanit_7': 'r1_at3_sanit_7', 'at4_notify_5': 'r1_at4_notify_5'}
        '''
        dfA = self.dfA[self.dfA['allocid']==allocID]
        all_alloc_tasks_with_r = set()
        
        for i,row in dfA.iterrows():
            Row = row
            if type(row['uniqueAlloc'])==float: # NaN is read like a float class
                # get reference row, cause this row do not have uniqueAlloc
                s = row['reference'].split("_")
                allocIDref = s[0]
                numClusRef = s[1]
                
                dfB = self.dfA[self.dfA['allocid']==allocIDref]
                dfB = dfB[dfB["num_cluster"]==int(numClusRef)]
                Row = dfB.iloc[0]
            
            all_alloc_tasks_with_r.update( eval( Row['uniqueAlloc'] ) )
        
        #print('all tasks with their robots:',all_alloc_tasks_with_r) # e.g. {'r1_at4_notify_5', 'r1_at2_floor_6', 'r1_at3_sanit_10', 'r3_at1_move_0', 'r1_at2_floor_12', 'r1_at4_notify_8', 'r2_at4_notify_11', 'r1_at2_floor_9', 'r3_at1_move_1', 'r1_at3_sanit_7', 'r1_at4_notify_2', 'r2_at3_sanit_4', 'r1_at3_sanit_13', 'r5_at1_move_0', 'r2_at2_floor_3', 'r5_at1_move_1'}
        task_to_rTask = {} # dic
        robots = []
        
        for i in all_alloc_tasks_with_r:
            s = i.split('_',1)
            rob = s[0]
            task = s[1]
            #save robots
            robots.append(rob)
            #save task
            if task in task_to_rTask.keys():  # if already saved (is a joint task)
                task_to_rTask[task].append(i)
            else:
                task_to_rTask[task] = [i]

        robots = list(dict.fromkeys(robots)) # remove repeated robots
        #print("======",task_to_rTask)   # e.g. ====== {'at2_floor_3': ['r2_at2_floor_3'], 'at1_move_0': ['r3_at1_move_0', 'r5_at1_move_0'], 'at2_floor_6': ['r1_at2_floor_6'], 'at4_notify_8': ['r1_at4_notify_8'], 'at1_move_1': ['r5_at1_move_1', 'r3_at1_move_1'], 'at2_floor_12': ['r1_at2_floor_12'], 'at4_notify_5': ['r1_at4_notify_5'], 'at4_notify_11': ['r2_at4_notify_11'], 'at3_sanit_7': ['r1_at3_sanit_7'], 'at3_sanit_10': ['r1_at3_sanit_10'], 'at2_floor_9': ['r1_at2_floor_9'], 'at3_sanit_13': ['r1_at3_sanit_13'], 'at3_sanit_4': ['r2_at3_sanit_4'], 'at4_notify_2': ['r1_at4_notify_2']}
        #print(robots)# e.g. ['r2', 'r3', 'r1', 'r5']
        return task_to_rTask , robots
        


class problem():
    def __init__(self , file):
        # 1) read file
        fileMissionTree = file # e.g.: "/Users/gris/eclipse-workspace/uoy.mrs/TestCase3-var4/dslmodel/src-gen/modelMissionsTree.txt"
        self.dfTasks = pd.read_csv(fileMissionTree,sep=",,",engine ='python', skip_blank_lines=True) #need engine=python when separator is more than one character
        
        # 2) instantiate mission and tasks
        allInstances,missions,at, ct = self._getInstances(self.dfTasks)
        self.allInstances = allInstances # all (ct, at, miss)
        self.missions = missions 
        self.at = at # atomic tasks
        self.ct = ct #compound tasks
        
        # 3) get feasible permutation of tasks
        self.resultTaskList = [] # run "getFeasibleTaskPerm()" to get a new list of feasible task permutations  
        # RUN this to get permutations:
        #self.getFeasibleTaskPerm()
        
    
        
        
    
    def _getInstances(self,df):        
        # 2) get instances
        allInstances = {}
        # get  missions
        missions = {}
        for i,row in df[df['parent'].isna()].iterrows(): # parent null
            m_name = row['id']            
            m_children = eval(row["ordered_children"]) 
            
            missions[m_name] = mission(m_name,m_children)
            allInstances[m_name] = missions[m_name]
        # get tasks
        at, ct = {} , {}
        for  i,row in df[df['parent'].notna()].iterrows(): #parent not null
            # atomic task
            if type(row['ordered_children'])==float: # NaN is read like a float class
                at_name = row['id']
                at_type= 'at'
                at_parent = row['parent']
                at_loc = row['location']
                at_joint = row['joint']
                at[at_name]=atomic(at_name,
                                   at_type,
                                   at_parent,
                                   at_loc,
                                   at_joint)
                allInstances[at_name] = at[at_name]
                
            #compound task
            else:
                ct_name = row['id']
                ct_type = 'ct'
                ct_parent = row['parent']
                ct_children = eval(row['ordered_children'])
                ct_ordered = row['ordered']
                ct_consecutive = row['consecutive']
                ct[ct_name] = compound(ct_name,
                                       ct_type,
                                       ct_parent,
                                       ct_children,
                                       ct_ordered,
                                       ct_consecutive)
                allInstances[ct_name] = ct[ct_name]
        
        # add mission (root) tasks as a compound task
        allInstances = self._getRoot(missions,allInstances)
        return allInstances,missions,at, ct
    
    
    def isMission(self,task):
        if task in self.missions.keys():
            return True
        return False

    def isCompound(self,task):
        if task in self.ct.keys():
            return True
        return False
    
    def isAtomic(self,task):
        if task in self.at.keys():
            return True
        return False
    
    def _getRoot(self,missions,allInstances):
        # Get root (mission) as a compound task with children been the mission tasks
        children = []
        for m in missions.values():
            children.append(m.ordered_children[0])
        allInstances['root'] = compound('root',
                               'ct',
                               '', # parent
                               children, # children
                               False,# ordered
                               False)#consecutive
        #print('Root: ', allInstances['root'].ordered_children)
        return allInstances;
        
    def getFeasibleTaskPerm(self):
        '''This is the actual algorithm to get a feasible permutation of tasks.
        Not by robot yet, directly from mission tree.txt '''
        # 1) reset list
        self.resultTaskList = []
        allInst = self.allInstances # save info as is going to iterate recursivelly and delete it
        # 2) get all atomic tasks until no atomic/compound task left in the tree
        while self.allInstances['root'].ordered_children: 
            #print(self.resultTaskList)
            task1id = self.allInstances['root'].id
            self._getNextTask(task1id)
        # 3) restore instances
        self.allInstances = allInst
        # 4) return feasible permutation of tasks
        return self.resultTaskList # resultTaskList modified after this function finishes
    
    def _getNextTask(self,task1id):
        '''From a taskId, retrieve leave atomic task 'recursively'
        and check if none left, no this task can be deleted.'''
        
        task1 = self.allInstances[task1id] # task
        # if atomic
        if task1.type == 'at':
            # add task to resulting list
            #global resultTaskList 
            self.resultTaskList.append(task1id)
            removeid = task1id 
            return removeid
        # if compound ordered
        elif task1.ordered:
            taskChild = task1.ordered_children[0]
            removeid = self._getNextTask(taskChild)
            if removeid: # if returned not empty, remove task from its children
                self.allInstances[task1id].ordered_children.remove(removeid)
                removeid = []
                # if last children removed, send also to remove this task to last call
                if not task1.ordered_children:
                    removeid = task1id
            return removeid
            
        elif not task1.ordered:
            taskChild = random.choice(tuple(task1.ordered_children))
            removeid = self._getNextTask(taskChild)
            if removeid: # if returned not empty, remove task from its children
                self.allInstances[task1id].ordered_children.remove(removeid)
                removeid = []
                # if last children removed, send also to remove this task to last call
                if not task1.ordered_children:
                    removeid = task1id
            return removeid
    
    
    
    
def flush_sys_streams() -> None:
    """
    flushes the output streams.

    flush calls are wrapped in try ... except, because 
    standard streams might be replaced with other streams which 
    dont have the flush method.
    https://stackoverflow.com/questions/63254323/python-loop-keeps-stopping-in-windows-interpreter
    """
    try:
        sys.stdout.flush()
    except Exception:
        pass
    try:
        sys.stderr.flush()
    except Exception:
        pass
    

# ------------MAIN--------------------
if sys.argv[4] == "Permutations_and_MDPCreate":
    
    # 1) get permutations:
    # inputs
    permutationsFile = sys.argv[1]
    missionTreeFile = sys.argv[2]
    allAllocFile = sys.argv[3]
    # remove input stream
    flush_sys_streams()
    # save permutations
    allocationsPermutations(missionTreeFile,permutationsFile,allAllocFile)
    # print done
    print("Permutations saved at: ",permutationsFile)
    
    # 2) get atomic tasks constrained (used in the MDPs creation)
    tasksBeforeATs(missionTreeFile)
    
else:
    print("ERROR: please check inputs to Python when creating an MDP. 9th should be MDPCreate string.")
