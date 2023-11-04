import os
import auxiliary.utility
from auxiliary.utility import rename
#from auxiliary_data_alloy import robotsDSLinfo
from classes.problemSpecification import ProblemSpecification

from auxiliary.utility import isJoin

def r_Module(p:ProblemSpecification,r,a,c):
    
    r_permutation = c.robotPermutations
    
    
    '''Prism module for a robot'''
    atasks = r_permutation[r].tasks
    #7.1) initialize module r
    s = "\n\n\n//---------- Robot "+r+" MODULE----------"
    s += "\nmodule "+r
    # 7.2) order description
    s += "\n  //{}_order=0: travel cost ".format(r)
    # 7.2.1) atomic tasks description
    count = 0# 0-1 is travel, 1- start tasks
    for at in atasks:
        count +=1
        if isJoin(a.dfAllocation,at):
            # state1: travel to task
            s +="\n  //{}_order={}: time travel to join task {}".format(r,count,at)
            # state2: synchronize with other robots
            count+=1
            s +="\n  //{}_order={}: join task {}".format(r,count,at)
        else:
            s +="\n  //{}_order={}: task {}".format(r,count,at)
            
    # 7.3) initialise states
    s +="\n  {}_order: [0..{}] init 0; // execution order".format(r,a.get_rnumStates(r,r_permutation[r]))
    s +="\n  {}_time:[0..TT] init 0; //time available".format(r)
    s +="\n  {}_travel: [0..1] init 0; // get travelling reward".format(r)
    s +="\n  {}_fail: [0..1] init 0; // failure detected".format(r)
    
    
    s +="\n // limit idle per robot"
    s += "\n  i_{} : [0..TT];".format(r) # TT is the max. but not reached if "r_max_idle_times"<TT
    
    
    ############# Modifying part of getting constraint tasks
    
    at_beforeDir = p.at_beforeDir
    at_before = list(set().union(*at_beforeDir.values())) # e.g.: ['at4_notify_11', 'at4_notify_5', 'at4_notify_2', 'at4_notify_8']
    
    #############
    
    '''
    DEPRICATED
    ord = [] # atasks part of ordered task tree
    for t in atasks:
        if a.isAtomicPartOfOrdered(t)[0]:
            ord.append(t)
    if ord!=[]:
    '''
    
    
    '''Get robots to be done by robot. For join task, only add to first robot'''
    r_at_before = [] # tasks that have to be done before others assigned to this robot, 
    for at in atasks:
        if at in at_before:
            if not isJoin(a.dfAllocation,at):
                r_at_before.append(at)
            else:
                if r == a.getrobotsSharingJoinTask(at)[0]: # add task to first robot only
                    r_at_before.append(at)
                else:
                    pass
    if r_at_before:
        s+=('\n\n  // tasks to track for ordering constraints')
        for t in r_at_before:
            s+=('\n  {}:[0..1];').format(t)
    
    '''Transitions '''
    # 7.4) travel
    s +="\n\n  // travel captured as a reward"
    s +="\n  [{}travel] {}_order=0 -> ({}_order'=1);".format(r,r,r)
    #7.5) tasks 
    s +="\n  // do sequence of tasks"
    count=0
    states = _getStatesOfTasks(r, a, atasks) # dictionary array
    for at in atasks:
        count+=1
        tGeneric = a.get_task_generic(at)
        
        # check if part of a constraint task
        '''order_task = a.isAtomicPartOfOrdered(at);
        isOrder = order_task[0]
        isOrder = order_task[0]
        #print(order_task)
        '''
        #### Modified
        
        ####
        
        # 7.5.1) if join: add travel and synchronise robots
        if isJoin(a.dfAllocation,at):
            # a) travel
            travelTime = _get_travel(r,a,p,count,states)
            s +="\n  [ ] {}_order={} & {}_fail=0 & ".format(r,count,r)
            s +="({}_time+{}<=TT) -> (p{}_Succ_{}): ".format(r,travelTime,r,tGeneric)
            s +="({}_order'={}) & ({}_time'= {}_time+{})".format(r,count+1,r,r,travelTime)
            s +="+ (1-p{}_Succ_{}): ({}_fail'=1) & ".format(r,tGeneric,r)
            s +="({}_order'={}) & ({}_time'= {}_time+{}); // travel to join task {}".format(r,count+1,r,r,travelTime,at)
            # b) synchronise and do task
            count+=1
            s +="\n  [{}] {}_order={} & {}_fail=0 & ".format(at,r,count,r,)
            s +="({}_time+{}{}Time<=TT)".format(r,r,at)
            # add all robots sharing joint task to start at the same time
            s2=""
            for r2 in a.getrobotsSharingJoinTask(at):
                if r2!=r: # synch times with others
                    s2+=" & {}_time={}_time".format(r,r2)
            # if join task part of ordered task, add task to first robot
            if at in at_before:
                if r== a.getrobotsSharingJoinTask(at)[0]:
                    s2+=" & {}=1".format(at)
                    
            #--- ERROR: If no two robots found
            if s2=="":
                print('ERROR: No two robots found sharing task '+at)
                raise SystemExit('ERROR: No two robots found sharing task '+at)
            #---
            s += s2 + " -> ({}_order'={}) & ({}_time'= {}_time + {}{}Time);".format(r,count+1,r,r,r,at)
            
        #7.5.2) if ordered        
        elif at_beforeDir[at]:
            #children = order_task[1].atomicChildren  
            #print("Children to check:",children,children.index(at))
            #print("Children of:", order_task[1].idInAllocation ,order_task[1].atomicChildren )          
            travelTime = _get_travel(r,a,p,count,states)
            s +="\n  [T{}{}] {}_order={} & {}_fail=0".format(r,at,r,count,r)
            # check all tasks before are done
            #print("t:" +at)
            '''
            lastTask = ""
            # get tasks before current one
            tasksBefore = []
            if children[0]!=at: # if not first task to be done
                tasksBefore = children[0:children.index(at)]
                lastTask = tasksBefore[-1]# get last task
                                       
            #print("tasks before",tasksBefore)
            while tasksBefore: #do all atomic tasks before
                t = tasksBefore.pop()
                s +=" & {}=1".format(t)
            '''
            
            for tBefore in at_beforeDir[at]:
                s +=" & {}=1".format(tBefore)
            
            lastTask = at_beforeDir[at][0]
            
            # check last robot(s) have time greater or equal
            if lastTask!="": #if it has a task i-1
                for rBefore in auxiliary.utility.getRobot(lastTask,a): #for all robots with last atask
                    if rBefore!=r: #no need to repeat if allocated to same robot
                        s +=" & {}_time>={}_time".format(r,rBefore)                    
                # else: there is no at before at, and no synch needed 
            #continue 
            s +=" & ({}_time+ {}{}Time + {} <=TT) -> (p{}_Succ_{}): ".format(r,r,at,travelTime,r,tGeneric)
            
            if at in r_at_before: # add atomic task = 1 (done)
                s +="({}_order'={}) & ({}_time'= {}_time+ {}{}Time + {}) & ({}'=1)".format(r,count+1,r,r,r,at,travelTime,at)
                s +="+ (1-p{}_Succ_{}): ({}_fail'=1) & ".format(r,tGeneric,r)
                s +="({}_order'={}) & ({}_time'= {}_time+ {}{}Time + {}) & ({}'=1);".format(r,count+1,r,r,r,at,travelTime,at)
            else: # don't add if not part of this robot (or not first of a join task)
                s +="({}_order'={}) & ({}_time'= {}_time+ {}{}Time + {})".format(r,count+1,r,r,r,at,travelTime)
                s +="+ (1-p{}_Succ_{}): ({}_fail'=1) & ".format(r,tGeneric,r)
                s +="({}_order'={}) & ({}_time'= {}_time+ {}{}Time + {});".format(r,count+1,r,r,r,at,travelTime)
        #7.5.3) not join & not ordered
        else:
            # a) travel and do task
            travelTime = _get_travel(r,a,p,count,states)
            s +="\n  [T{}{}] {}_order={} & {}_fail=0 & ".format(at,r,r,count,r)
            s +="({}_time+ {}{}Time + {} <=TT) -> (p{}_Succ_{}): ".format(r,r,at,travelTime,r,tGeneric)
            if at in r_at_before: # add atomic task = 1 (done)
                s +="({}_order'={}) & ({}_time'= {}_time+ {}{}Time + {}) & ({}'=1)".format(r,count+1,r,r,r,at,travelTime,at)
                s +="+ (1-p{}_Succ_{}): ({}_fail'=1) & ".format(r,tGeneric,r)
                s +="({}_order'={}) & ({}_time'= {}_time+ {}{}Time + {}) & ({}'=1);".format(r,count+1,r,r,r,at,travelTime,at)
            else:
                s +="({}_order'={}) & ({}_time'= {}_time+ {}{}Time + {})".format(r,count+1,r,r,r,at,travelTime)
                s +="+ (1-p{}_Succ_{}): ({}_fail'=1) & ".format(r,tGeneric,r)
                s +="({}_order'={}) & ({}_time'= {}_time+ {}{}Time + {});".format(r,count+1,r,r,r,at,travelTime)
        
        
    #
    s += "\n\n  // failure and recovery, idle"
    s += "\n  [ ] {}_fail=1 -> ({}_fail'=0); // fail".format(r,r)
    s += "\n  [{}idle] {}_order!={} & {}_fail=0 & ".format(r,r,count+1,r) # count+1 = last state in robot module
    s += "({}_time+1<=TT) & (i_{}<{}) -> (i_{}'=i_{}+1) & ({}_time'={}_time+1); // idle".format(r,r,"maxIdle",r,r,r,r)
    # end module
    s += "\nendmodule"
    return s
    
    
def _get_travel(r,a,p,numState,states):
    # travelling from initial position of the robot
    # 0-1 travel cost
    # 1-2 
    if numState==1:
        #get initial location of the robot
        loc1 = p.robot_classes[r].init_loc
    else:
        #get location of task to do
        at = states[numState]
        loc1 = a.getloctask(at)
    #get location of task to do
    at = states[numState+1]
    loc2 = a.getloctask(at)
    
    return p.worldModel.get_dist_loc1loc2(loc1,loc2)
    
    
def _getStatesOfTasks(r, a, tasksInPerm):
    count = 1# 1 is travel, 2 start tasks
    states = {} # {2:at1, 3:travelJT1, 4:JT1, 5:...}
    for at in tasksInPerm:
        count +=1
        if isJoin(a.dfAllocation,at):
            # state1: travel to task
            states[count]=at
            # state2: synchronise with other robots
            count+=1
            states[count]=at
        else:
            states[count]=at
    return states

  
    
    






##### DEPRICATED FROM HEREß
    
    
####### DEPRICATED
def _robot_Module_probabilistic(p,r,a,c,tasksPermutation,at4orderedTasks):
    '''Prism module for a robot'''
    s = ""
    robot_classes = c.robotClasses
    travelDist = a.get_rTravellingDistance(r,p,tasksPermutation)
    
    # locations to travel (info string)
    locs = a.get_rLocationsToVisit(r,p,tasksPermutation)             
    s_travel = "->".join(locs)
    
    #5.1) initialize module r
    s += "\n\n\n//---------- Robot "+r+" MODULE----------"
    # if it only one, do not add "evolve"
    onlyOnePermutation = True if len(a.get_nPermutations(r,p))==1  else False
    if onlyOnePermutation or not p.evochecker:
        s += "\nmodule "+r
    else:
        s += "\nevolve module "+r
    
    #states
    s += "\n {}time:[0..TT]; // track time;".format(r)
    s += "\n {}_order:[0..{}]; // execution order".format(r,str( a.get_rnumStates(r) ))
    s += "\n {}_travDist:[0..{}] init {};// travelling cost for {}".format(r,travelDist,travelDist,s_travel)
    s += "\n {}_fail : [0..1];   // failure state".format(r)
    
    
    #constrained tasks
    const_t = []
    for i in range (0,len(robot_classes[r].tasks)):
        t = robot_classes[r].tasks[i] # task
        if t in at4orderedTasks:
            const_t.append(rename(r,t))
    if len(const_t)>=1:
        s += "\n// constrained tasks"
        for trenamed in const_t:
            s += "\n {}:[0..1];".format(trenamed)
    
    # travel transition  
    s += "\n // get travel as a cost"
    s += "\n [{}travel] {}_order=0 -> ({}_order'=1);".format(r,r,r,r)  
        
    state = 1
    for i in range (0,len(robot_classes[r].tasks)):
        #task = robot_classes[r].tasks[i] # task
        t = robot_classes[r].tasks[i] # task
        trenamed = rename(r,t)
        tGeneric,aa = t.rsplit("_", 1)

        if i==0: # get initial robot location
            t0 = 'init'
            loc1 = p.robot_classes[r].init_loc 
            
        else: # get task location
            t0 = robot_classes[r].tasks[i-1] # get task
            loc1 = a.getloctask(t0)
        
        # Get time to travel
        loc2 = a.getloctask(t)
        dist = p.worldModel.get_dist_loc1loc2(loc1,loc2)
        travelTime = robot_classes[r].velocity * dist
        
        
        
        
        if t in at4orderedTasks: # if task is part of a constrained (ordered) task
            s += "\n [{}_{}_{}]".format(r,t0,t)
            s += " {}_order={} & ({}time+ {}time+ {} <=TT) & ({}_fail=0)".format(r,state,r,trenamed,travelTime,r)
            s += "-> p{}_Succ_{}: ({}_order'={}) & ({}time'={}time+ {}time+ {}) & ({}'=1) ".format(r,tGeneric,r,state+1,r,r,trenamed,travelTime,trenamed)
            s += "+ (1-p{}_Succ_{}):({}_fail'=1) & ({}_order'={}) & ({}time'={}time+ {}time+ {}); //constrained task".format(r,tGeneric,r,r,state+1,r,r,trenamed,travelTime)
        else:
            s += "\n [{}_{}_{}]".format(r,t0,t)
            s += " {}_order={} & ({}time+ {}time+ {}<=TT) & ({}_fail=0)".format(r,state,r,trenamed,travelTime,r)
            s += "-> p{}_Succ_{}: ({}_order'={}) & ({}time'={}time+ {}time + {}) ".format(r,tGeneric,r,state+1,r,r,trenamed,trenamed,travelTime)
            s += "+ (1-p{}_Succ_{}):({}_fail'=1) & ({}_order'={}) & ({}time'={}time+ {}time + {});".format(r,tGeneric,r,r,state+1,r,r,trenamed,travelTime)
        
        if isJoin(a.dfAllocation,t): # add a new state for join transition
            state+=1 
            s += "\n //join task"
            s += "\n [{}] {}_order={} & ({}time<=TT) & ({}_fail=0) -> ({}_order'={});".format(t,r,state,r,r,r,state+1)
        state+=1 # update state to go to next, task (join task counted 2 states). Note: "i" only track tasks 
        
    # failure
    s += "\n //failure"
    s += "\n [{}Fail] {}_fail=1 -> ({}_fail'=0);".format(r,r,r)
    
    #idle (non-deterministic action in the MDP)
    s += "\n //idle"
    s += "\n [{}idle] {}_order!={} & ({}time+1<=TT) & ({}_fail=0)-> ({}time'={}time+ {});".format(r,r,state,r,r,r,r,p.idle_reward) #idle (non-deterministic action in the MDP, hence, the policy leads to minimize idle)
    # end module
    s += "\nendmodule"
    return s





########depricated
def _robot_Module(r,r_njt_states,robot_classes,travels,dfAllocation,at4orderedTasks,evochecker):
    
    ########depricated
    
    s = ""
    #5.1) initialize
    # module r
    s += "\n\n\n//---------- Robot "+r+" MODULE----------"
    if evochecker:
        s += "\n\nevolve module "+r
    else:
        s += "\n\nmodule "+r
    s += "\n {}_order:[1..{}]; //execution order".format(r,str(r_njt_states[r][1]))
    s += "\n {}time:[0..TT]; // total time;".format(r)
    #constrained tasks
    for i in range (0,len(robot_classes[r].tasks)):
        t = robot_classes[r].tasks[i] # task
        if t in at4orderedTasks:
            trenamed = r+"_"+t
            s += "\n {}:[0..1]; //part of constrained task".format(trenamed)
    # transitions
    state = 1
    for i in range (0,len(robot_classes[r].tasks)):
        t = robot_classes[r].tasks[i] # task
        if i==0:
            t0 = 'init' # init loc of robot
        else:
            t0 = robot_classes[r].tasks[i-1] # task
        trenamed = r+"_"+t
        if t in at4orderedTasks: # if task is part of a constrained (ordered) task
            s += "\n [{}_{}_{}] ({}_order={}) & ({}time+ {}time<=TT) -> ({}time'={}time+ {}time)&({}_order'={})&({}'=1); //constrained task".format(r,t0,t,r,state,r,trenamed,r,r,trenamed,r,state+1,trenamed)
        else:
            s += "\n [{}_{}_{}] ({}_order={}) & ({}time+ {}time<=TT) -> ({}time'={}time+ {}time)&({}_order'={});".format(r,t0,t,r,state,r,trenamed,r,r,trenamed,r,state+1)
        #save path for travel reward
        travels.append([r,t0,t])
        if isJoin(dfAllocation,t):
            state+=1 # add a new state for join transition
            s += "\n //join"
            s += "\n [{}] ({}_order={}) & ({}time+ {}time<=TT) -> ({}_order'={});".format(t,r,state,r,trenamed,r,state+1)
        state+=1 # update state to go to next, task (join task counted 2 states). Note: "i" only track tasks 
    
    
    #idle (non-deterministic action in the MDP, hence, the policy leads to minimize idle)
    s += "\n [{}idle] ({}time+ 1<=TT) & {}_order!={} -> ({}time'={}time+ {});".format(r,r,r,state,r,r,p.idle_reward)
    # end module
    s += "\nendmodule"
    
    ########depricated
    
    return s , travels



