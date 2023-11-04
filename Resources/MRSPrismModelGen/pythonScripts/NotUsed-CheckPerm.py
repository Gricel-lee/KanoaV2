import random

def getValidGene(tasks):
    
    feasiblePerm = []
    
    t = [j for i in tasks for j in i] # list of all tasks
    for i in range(0,len(t)):
        # get random task from the firsts in each sequence of tasks
        ran = random.randrange(0, len(tasks))
        t = tasks[ran].pop(0)
        feasiblePerm.append(t)
        
        # remove if empty task list
        if len(tasks[ran])==0:# if last one, remove task
            tasks.pop(ran)
    
    #getPermutationNumber(feasiblePerm)
    
    return feasiblePerm
    

#def getPermutationNumber(feasiblePerm):
#    n = max(feasiblePerm)
#    root = 0
#    for i in range(0,len(feasiblePerm)):
#        root *= n+1
#        root +=feasiblePerm[i]
#    print(root)


for i in range(0,10):
    orderedTasks = [[1,11,111],[2,22,222],[3,33],[4,44]]

    g = getValidGene(orderedTasks)
    print(g)



def getValidGene2(tasks):
    
    while tasks:
        t = tasks.pop()
        print(t)

orderedtasks = {1,2,3,(5,6,7)}

getValidGene2(orderedTasks)




import pandas as pd
import math

class mission():
    def __init__(self,name,children):
        self.id = name
        self.ordered_children = children
   
class atomic():
    def __init__(self,name,type,parent,loc,joint):
        self.id = name
        self.type = type
        self.parent = parent
        self.loc = loc
        self.joint = joint
  
class compound():
    def __init__(self,name,type,parent,children,ord,cons):
        self.id = name
        self.type = type
        self.parent = parent
        self.ordered_children = children
        self.ordered = ord
        self.cons = cons



# 1) read file
fileMissionTree = "/Users/gris/eclipse-workspace/uoy.mrs/TestCase3-var4/dslmodel/src-gen/modelMissionsTree.txt"
df = pd.read_csv(fileMissionTree, sep=',,')

print(df.to_string())


def getInstances():
    
    # 2) get instances
    allInstances = {}
    # get  missions
    missions = {}
    for i,row in df[df['parent'].isna()].iterrows(): # parent null
        m_name = row['id'],
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
    
    
    allInstances = getRoot(missions,allInstances)
    return allInstances,missions,at, ct



def getRoot(missions,allInstances):
    # Get root (mission) as a compound task with children been the mission tasks
    children = []
    for m in missions.values():
        children.append(m.ordered_children[0])
    allInstances['root'] = compound('root',
                           'ct',
                           '', # parent
                           children, # children
                           False,
                           False)
    return allInstances;




    

# START
import random

# global variables
allInstances,missions,at, ct = getInstances()


resultTaskList = []

print('Root: ', allInstances['root'].ordered_children)



#while allInstances['root'].ordered_children:



def getNextTask(task1id):
    
    print('      - ' ,task1id)
    
    task1 = allInstances[task1id]
    print("           ",task1.type)
    
    
    if task1.type == 'at':
        # add task to resulting list
        #global resultTaskList 
        resultTaskList.append(task1id)
        removeid = task1id 
        return removeid
    
    
    
    
    elif task1.ordered:
        
        print("           ",task1.ordered)
        
        taskChild = task1.ordered_children[0]
        removeid = getNextTask(taskChild)
        
        if removeid: # if not empty
            
            # remove task form its children
            #global allInstances
            allInstances[task1id].ordered_children.remove(removeid)
            removeid = []
            # if last children removed, send also to remove this task
            if not task1.ordered_children:
                removeid = task1id
        
        return removeid
        
        
        
    elif not task1.ordered:
        
        print("           ",task1.ordered)
        
        
        taskChild = random.choice(tuple(task1.ordered_children))
        removeid = getNextTask(taskChild)
        
        if removeid: # if not empty
            
            # remove task form its children
            #global allInstances
            
            print(allInstances[task1id].ordered_children)
            print(type(allInstances[task1id].ordered_children))
            
            allInstances[task1id].ordered_children.remove(removeid)
            removeid = []
            # if last children removed, send also to remove this task
            if not task1.ordered_children:
                removeid = task1id
        
        return removeid


    

while allInstances['root'].ordered_children:
    
    
    print( allInstances['root'] , "--------------")
    print(resultTaskList)
    
    
    task1id = allInstances['root'].id
    getNextTask(task1id)

