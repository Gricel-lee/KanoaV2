from auxiliary.utility import get_generic_task
#from prismFiles.mydslRobots import robotsDSLinfo

from auxiliary.utility import isJoin
from prismFiles.prismModule import r_Module
#from prismFiles.evoProperties import create_PROP_file

from classes.cluster import Cluster
from classes.allocation import Allocation
from classes.permutation import Permutation
from classes.problemSpecification import ProblemSpecification
    

def create_MDP_files(a:Allocation,p:ProblemSpecification,c:Cluster):
    ''' Create PRISM MDP files'''
    # 1) Save permutation classes in cluster class
    r_permutation = {} # perm. of tasks assigned to robot r
    for r in c.cluster:
        r_permutation[r] = Permutation(p,a,r,c.perm_num)
    c.robotPermutations = r_permutation # save to cluster
    
    
    # 2) Create MDP
    create_MDP_file(a,p,c)

def create_MDP_file(a:Allocation,p:ProblemSpecification,c:Cluster):
    ''' Create PRISM MDP file for each permutation'''
    file = c.nameFileMDP("mdp")
    #print("doing permutation: ",c.perm_num)
    
    with open(file, 'w') as f:
        ''' MDP initialisation '''
        # 1) mdp
        f.write("mdp")
        # 2) label done - moved to .prop
        s_times,s_done = _formulae_Done_n_TaskTimes(c,a,p)
        # 3) formula done
        f.write(s_done)
        # 3) formula fail
        f.write("\n\n// success")
        s = ""
        for r in c.cluster:
            s += r+"_fail=0 & " 
        f.write("\nformula success = ({});".format(s[:-2]));
        # 4) total time
        f.write("\n\n// total time available")
        f.write("\nconst int TT={};".format(p.totalTime));
        # 5) 
        f.write("\n\n// maximum time for a robot to idle")
        f.write("\nconst int maxIdle={};".format(p.r_max_idle_times));
        
        # 6) task times
        f.write("\n\n// completion tasks time")
        f.write(s_times)
        # 7) prob. of succ.
        f.write("\n\n// probabilities of succeeding with a task")
        s_prob, totalProb = _const_prob_succ(p,c)
        f.write(s_prob)
        # 8) travelling cost
        f.write('\n\n// travelling costs of each robot')
        totalTravel = 0 # get total travel
        for r in c.cluster:
            travelDist = c.get_rTravellingDistance(r,a,c.robotPermutations[r].tasks)
            locs = a.get_rLocationsToVisit(r,p,c.robotPermutations[r].tasks) #locations to travel (info string)             
            s_travel = "->".join(locs)
            f.write("\nconst int {}_travDist = {}; //{}".format(r,travelDist,s_travel))
            totalTravel+=travelDist # get total travel
        # 7) tasks explicit for ordering constraint
        
        
        # 8) modules
        '''Robot Modules'''
        for r in c.cluster:
            f.write(r_Module(p,r,a,c))
            
        # 9.1) reward "travel"
        f.write("\n\nrewards \"travel\" ")
        for r in c.cluster:
            f.write("\n [{}travel] true: {}_travDist;".format(r,r))
        f.write("\nendrewards")
        
        # 9.2) rewards "idle"
        f.write("\nrewards \"idle\" ")
        for r in c.cluster:
            f.write("\n [{}idle] true: 1;".format(r))
        f.write("\nendrewards")
        
        
        f.write("\n\n//total travel:")
        f.write("\n//{}//".format(totalTravel))
        
    return file, totalTravel, totalProb
    



def _formulae_Done_n_TaskTimes(c:Cluster,a:Allocation,p:ProblemSpecification):
    '''Form formula Done for Evochecker file'''
    s_times = ""
    s_done ="\n\nformula done = ("
    for r in c.cluster: # add formula "done" and const "task times" 
        nstates = len(c.robotPermutations[r].tasks)
        #print("Robot:   ",r)
        for t in c.robotPermutations[r].tasks:
            # - task times
            time = p.robot_classes[r].getTimeInt4Task(t,a)
            s_times += "\nconst int {}{}Time={};".format(r,t,time) # NOTE: I can round or truncate
            # - done (count joint as double)
            if isJoin(a.dfAllocation, t):
                nstates += 1
        # add num of states of robot r
        s_done+= "{}_order={} & ".format(str(r), str(nstates+1))
        #print('s_done ',s_done[:-3])
    
    s_done = s_done[:-3]+");"  
    return s_times,s_done



def _const_prob_succ(p,c):
    #robots_dsl,cluster):
    #p.robots.robots_tasksInfo,cluster
    '''Get string for each robot with each task and its probability of success'''
    s=""

    totalProb = 1
    
    already_added = []
    
    # 1) for each robot
    for r in c.cluster:
        # - get the tasks it must do
        atList = c.robotPermutations[r].tasks
        # - get prob. to do task
        for at in atList:
            
            at_gen = get_generic_task(at)
            prob = c.robotClasses[r].capabilities_at[ at_gen ]
            totalProb = totalProb * float(prob)
            
            s_new = "\nconst double p{}_Succ_{} = {};".format(r,at_gen,prob)
            if s_new not in already_added:
                already_added.append(s_new)
                s+= s_new
            
    return s, totalProb




def time_completion(r,t,robots_dsl):
    '''Get the time for a robot r to complete task t'''
    try:
        t = t.rsplit("_",1)[0] # without alloy assigning
        
        i = robots_dsl[r][0].index(t) # index of task
        time = robots_dsl[r][1][i]
        prob = robots_dsl[r][2][i]
        
    except:
        #print('Error in robot ',r,' capabilities:'+robots_dsl[r][0],' while looking for:',t)
        raise RuntimeError('Error in robot ',r,' capabilities:'+robots_dsl[r][0],' while looking for:',t)
    #
    #    t_without_assig.append( t.rsplit("_",1)[0] ) 
    #
    return time,prob


