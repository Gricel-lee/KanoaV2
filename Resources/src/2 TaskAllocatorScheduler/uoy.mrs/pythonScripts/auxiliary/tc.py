'''
This file contains functions required by "allocation" class.

Author: Gricel Vazquez 31/03/2022
'''
import numpy as np
from collections import OrderedDict
import sys
from auxiliary.utility import _get_list_of_robots

def get_transitive_closure(dfAllocation,dfTasks):
    '''Get robot clusters by Transitive Closure
     (cluster of robots sharing constraints), e.g.:
    [['r4$0', 'r3$0', 'r11'], ['r2$0']] '''
    #"Starting transitive closure"
    robotclusters = _get_cluster_robots_with_constraints(dfAllocation,dfTasks)
    #"Done transitive closure"
    if len(robotclusters)==0: # ERROR - at least one robot should have been found
        sys.exit("No robot cluster found for allocation .")
    return robotclusters


def _get_cluster_robots_with_constraints(dfAllocation,dfTasks):
    # 1) get list of robots
    r_list = _get_list_of_robots(dfAllocation)#print("list of robots: ",r_list)
    # 2) get clusters of constrained robots by the higher level task
    robotsubClusters = _get_subclusters_of_tasks_with_constraints(dfAllocation,dfTasks)
    #print("all subclusters: ",robotsubClusters)
    
    allclusters = []

    # 3) transitive closure
    while r_list:               # while robots not checked
        #print("r_list: ",r_list)
        # a) start a new cluster of robots
        r0 = r_list.pop(0)      # get first robot
        #print("r0: ",r0)
        cluster = [r0]          # initialize new cluster
        #print("cluster: ",cluster)
        r0_collaborates_with_robots = [] # list of subclusters containing r0
        #print("all subclusters: ",robotsubClusters)
        # b) get all subclusters with r0
        for i in robotsubClusters:
            #print("subcluster: ",i)
            if r0 in i: # if it contains r0
                #print("contains: ",r0)
                r0_collaborates_with_robots.extend(i)
            else: # if not contains r0
                pass
        # c) delete duplicate robots
        r0_collaborates_with_robots = list(OrderedDict((x, True) for x in r0_collaborates_with_robots).keys())
        #print("without duplicate: ",r0_collaborates_with_robots)
        # d) delete robots already checked
        tocheck = [x for x in r0_collaborates_with_robots if not x in cluster]
        #print("without already checked: ",tocheck)
        # e) while robots to check within the cluster:
        while tocheck:
            r1 = tocheck.pop(0) # first in the queue "to be checked" in the cluster
            #print("tocheck: ",tocheck)
            cluster.extend([r1])
            r1_collaborates_with_robots = []
            # -get all subclusters with r1
            for i in robotsubClusters:
                #print("sub to check: ",i)
                if r1 in i: # if it contains r1
                    r1_collaborates_with_robots.extend(i) #print("r1_collaborates_with_robots: ",r1_collaborates_with_robots)
                else: # if not contains r1
                    pass
            # -delete duplicate robots
            r1_collaborates_with_robots = list(OrderedDict((x, True) for x in r1_collaborates_with_robots).keys())
            #print("r1_collaborates_with_robots: ",r1_collaborates_with_robots)
            # -delete robots already checked or already in the queue "tocheck"
            new_tocheck = [x for x in r1_collaborates_with_robots if x not in cluster]
            #print("new_tocheck: ",new_tocheck)
            new_tocheck = [x for x in new_tocheck if x not in tocheck]
            #print("---new_tocheck: ",new_tocheck)
            tocheck.extend(new_tocheck) #new queue of robots to check
        # one cluster finished
        allclusters.append(cluster)
        flat_list_allclusters = [item for sublist in allclusters for item in sublist]
        # get all robots in all clusters check already
        clusters_robots_together = list(OrderedDict((x, True) for x in flat_list_allclusters).keys())
        # delete them from the original list of robots to check
        r_list = [x for x in r_list if not x in clusters_robots_together]
    #print("Transitive Closure: ",allclusters)
    return(allclusters)



def _get_subclusters_of_tasks_with_constraints(dfAllocation,dfTasks):
    # get tasks that have constraints
    t_constrained = _tasks_with_constraints(dfTasks)
    #print("constrained tasks: ",t_constrained)
    
    # start with the top, i.e., the ones without "parent"
    roots = list(dfAllocation.loc[dfAllocation['parent'].isnull()]['id']) # all mission tasks (e.g[t1,t2,t3])
    nodes = roots
    robotClusters = {}
    while nodes:
        # get first task in queue
        n = nodes.pop(0)
        #print('n',n)
        nGeneric = None
        if '_' in n:
            nGeneric = n.rsplit('_', 1)[0] # e.g. at1_move_0 -> at1_move
        #print('n: ',n, ', nGeneric:',nGeneric)
        
        # 1) if constrainted
        if nGeneric in t_constrained and nGeneric!=None:
            #print(n,' is constrainted')
            robotClusters[n] = _get_robots_doing_subtasks_of_n(n , dfAllocation) #joint, seq or cons, so n could be an atomic task
            #print(robotClusters)
            pass
        # 2) if not constrained
        else:            
            try: #if has children
                children = eval(dfAllocation.loc[dfAllocation['id']==n]['ordered_children'].values[0])
                nodes += children
                #print(n ,"children: ",children)
            except: # if no children /it is a leaf node/ atomic task    
                # if leaf is constrained or not, add it as a separate cluster
                robotClusters[n] = eval(dfAllocation.loc[dfAllocation['id']==n]['runbyrobot'].values[0]) #get_robot_doing_task_n
                #print(n ,"No children: ")
            finally:
                #print(robotClusters)
                pass
    # If no constraints found
    #if robotClusters == {}:
    #    print("No constraints found, all robots can be models separately on the scheduling part")
    # pass in to list of lists
    return list( robotClusters.values() )



def _tasks_with_constraints(dfTasks):
    constrained_tasks = list(dfTasks.loc[dfTasks['ordered']=='True']['id'])
    constrained_tasks.extend(list(dfTasks.loc[dfTasks['consecutive']=='True']['id']))
    constrained_tasks.extend(list(dfTasks.loc[dfTasks['joint']=='True']['id']))
    constrained_tasks = np.unique(constrained_tasks).tolist()
    #print('list of constraint tasks: ',constrained_tasks)
    return(constrained_tasks)


def _get_robots_doing_subtasks_of_n(n , dfAllocation):
    '''Get all the robots of the atomic tasks from node n'''
    _robotClusters = [] 
    _queue = [] # queue of children, until atomic tasks (leaves)
    # 1) Initialize queue:
    
    try: #if has children
        #print('children:: ',eval(dfAllocation.loc[dfAllocation['id']==n]['ordered_children'].values[0]))
        children = eval(dfAllocation.loc[dfAllocation['id']==n]['ordered_children'].values[0])
        _queue += children
    except: # if no children /it is a leaf node/ atomic task    
        # if leaf is constrained or not, add it as a separate cluster
        #print(dfAllocation.loc[dfAllocation['id']==n]['runbyrobot'].values[0])
        runbyrobot = dfAllocation.loc[dfAllocation['id']==n].iloc[0]
        #print('atomic:: ', eval(dfAllocation.loc[dfAllocation['id']==n]['runbyrobot'].values[0]) )
        _robotClusters.extend( eval(dfAllocation.loc[dfAllocation['id']==n]['runbyrobot'].values[0]) )#get_robot_doing_task_n
    # 2) Iterate over queue
    while _queue: #while there are nodes to expand
        # get first task in queue
        n = _queue.pop(0)
        try: #if has children
            children = eval(dfAllocation.loc[dfAllocation['id']==n]['ordered_children'].values[0])
            _queue += children
        except: # if no children /it is a leaf node/ atomic task    
            # if leaf is constrained or not, add it as a separate cluster
            #print(dfAllocation,n)
            #print(dfAllocation.loc[dfAllocation['id']==n].astype(str).values.flatten().tolist())
            _robotClusters.extend( eval(dfAllocation.loc[dfAllocation['id']==n]['runbyrobot'].values[0]) )#get_robot_doing_task_n
    
    # delete duplicates
    return(list(OrderedDict((x, True) for x in _robotClusters).keys()))









