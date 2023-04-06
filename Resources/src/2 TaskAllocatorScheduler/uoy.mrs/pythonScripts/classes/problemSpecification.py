import sys
import pandas as pd
import auxiliary
import os
import re
from classes.robot import Robot
from classes.capability import Capability
from classes.world import World
from auxiliary import utility
import auxiliary.mydsl
from auxiliary.printString import printIt2

class ProblemSpecification():
    def __init__(self):
        # 1) data input from Java
        #sys.argv = [sys.argv[0]] # python version
        self.alloyAllocDir = sys.argv[1]
        self.alloyAllocationsFiles =  self.alloyAllocDir + "/Allocation*.xml" # Alloy allocation outputs
        self.fileMissionTree = sys.argv[2] # Constants.MISSIONSTREEFILE
        self.fileDSL = sys.argv[3] #Constants.DSLFILE 
        self.path_tc = sys.argv[4] #Constants.TRANSITIVECLOSURE
        self.totalTime = sys.argv[5] #Constants.TOTALTIME4PLAN
        self.save_data = sys.argv[6] #True/False
        self.worldModel = World(sys.argv[7]) # Constants.WORLDTXTFILE 
        self.outputDir =sys.argv[8] # Constants.WORLDTXTFILE 
        self.dfTasks = self.update_dfTask()
        self.robot_classes, self.robotsIDs = self._getRobotInstances()
        self.idle_reward = 1
        
        
        
        # used to create MDPs
        self.path_mdp = ""
        self.permutationsFile = ""
        self.dfPermutations = [] # dataframe from permutations.csv
        self.r_max_idle_times = 30 # later, add it to DSL!!
        self.at_beforeDir = []
        
        # repository of unique allocation-cluster
        self.uniqueClusterAlloc = pd.DataFrame(columns=['allocid','num_cluster','uniqueAlloc','reference'])
        
        ''' self.uniqueClusterAlloc:
        Get unique combination of robots to tasks
        allocid num_cluster    uniqueAlloc                                          reference
        0        1  {r4_at4_notify_2, r5_at4_notify_5, r2_at4_noti...  ...  [room1, room6, room3, room1, room2, room6, roo...
        0        2  {r5_at4_notify_2, r2_at4_noti...                  ...  [room1, room6, room3, room1, room2, room6, roo...
        
        Repository of allocations saved as:
        uniqueClusterAlloc = ['allocid','num_cluster','uniqueAlloc','reference']    ...
        '''
        

    #def getalloyFiles(self):
    #    return self.alloyAllocations
    def getalloyFileswPath(self):
        return utility.getAlloyXMLpaths(self.alloyAllocationsFiles) 
    def getMissionsTreefile(self):
        return self.fileMissionsTree
    def getTransClosurePath(self):
        return self.path_tc
    def getfileDSL(self):
        return self.fileDSL
    def gettotalTime(self):
        return self.totalTime
    def saveData(self):
        return self.save_data
    def getWorldTxtFile(self):    
        return self.wm_file
    def getnPermut(self):
        return self.nPermut
    def getuniqueClusterAlloc(self):
        '''Get unique combination of robots to tasks
        AllocID TCID 
        0        1  {r4_at4_notify_2, r5_at4_notify_5, r2_at4_noti...  ...  [room1, room6, room3, room1, room2, room6, roo...
        0        2  {r5_at4_notify_2, r2_at4_noti...                  ...  [room1, room6, room3, room1, room2, room6, roo...
        
        'reference' is only added for already added allocations
         
        Repository of allocations saved as:
        uniqueClusterAlloc = ['allocid','TCid','uniqueAlloc','reference']    ...
        '''
        return self.uniqueClusterAlloc
    
    
    def getIdleReward(self):
        return self.idle_reward
    def getdfTasks(self):
        return self.dfTasks
    # get dsl info
    def update_dfTask(self):
        ''' Get dataframe with DSL tasks info
        e.g.:
                     id      type robots tasks ordered consecutive  joint
        0    ct1_clean   compound    NaN   NaN   False       False    NaN
        1  ct2_patient   compound    NaN   NaN    True       False    NaN
        2     at1_move     atomic     2    NaN     NaN         NaN   True
        3    at2_floor     atomic     1    NaN     NaN         NaN  False
        4    at3_sanit     atomic     1    NaN     NaN         NaN  False
        5   at4_notify     atomic     1    NaN     NaN         NaN  False
        '''
        return auxiliary.mydsl.getTasksDF(self.fileDSL) 
    
    def saveDSLTasksInfo(self):
        #if eval(self.save_data):
        self.dfTasks.to_csv( os.path.abspath(self.outputDir + "/TasksDSL.csv") )
        return
    
    def saveAllocInfo(self):
        #if eval(self.save_data):
        #print('Saving repository')
        Allocations = self.uniqueClusterAlloc.sort_values(by=['allocid'], ascending=True) # sort by allocation id
        Allocations.to_csv(self.outputDir + "/AllAllocations.csv")
        
    def saveUniqueallocations(self,allocations):
        with open(self.outputDir + "/Allocations.csv",'w') as file:
            for a in allocations:
                line = a.fileAlloy + "|" + str(a.num) + "|" + str(a.getNumRobots()) + "|" + str(a.robotclusters) + "|" 
                l = ""
                for r in a.allrobotsIDs :
                    tasks = a.get_rtasks_FromDatabase(r)
                    
                    l += r + ":"+ str(tasks) + "::"
                line += l[:-1]
                file.write(line)
                file.write('\n')
        
            
            
    
    
    def _getRobotInstances(self):
        robot_classes, robotsIDs = self._robotsDSLinfo()
        
        return robot_classes, robotsIDs  
    
    
    def _robotsDSLinfo(self):
        '''Get data from robots in the DSL file
           Robot completion times and probabilities of success from .mydsl
        
        e.g., robots_tasksInfo[r] = [atomic_tasks,time_required,success_probability]
        + list of capabilities instances
        + velocity
        + initial location
        '''
        capabilities = {}
        robots_tasksInfo= {}
        rVel = {}
        rInitLoc = {}
        
        with open(self.fileDSL) as f:
            lines = f.readlines()
            for i in range(0,len(lines)):       
                l = lines[i]    
                 
                # if not a comment
                comment = True if l.strip().startswith("//") else False 
                if not comment:
                    
                    # if a robot:      e.g. r5: at initial location l8 with capabilities c2,c3 can do
                    if "at initial location" in l:
                        r = l.strip().split(':')[0].replace(" ", "") #do not delete strip nor replace; only worked like this
                        capabilities[r]=[]
                        #print("robot",r)
                        
                        try:
                            loc  = l.replace(' ','').split('atinitiallocation')[1].split('hasvelocity')[0]
                            
                            vel  = int(float(l.replace(' ','').replace("\n","").split('hasvelocity')[1]))
                        
                            #print('init location=',loc)
                            #print('init location=',vel)
                            
                        except Exception:
                            print("Check problemSpecification.py")
                            print("Something went wrong when reading DSL robots location and velocity. Check if in same line.")
                        
                        
                        if r in robots_tasksInfo.keys():
                            print("Error. Robot {} may be specified twice in DSL".format(r))
                        
                        i+=1 # next line is "with capabilities c1,c3... can do"
                        
                        # get capabilities in the next lines
                        atomic_tasks,time_required,success_probability = [],[],[]
                        while i<len(lines): # for sec.
                            i += 1 # next line
                            l = lines[i]
                            l = re.sub('\s+', '', l) # delete tabs \b, spaces and enters \n 
                            # check if not a comment
                            comment = True if l.strip().startswith("//") else False 
                            if not comment:
                                # begin of capabilities info
                                if "(" in l:
                                    l = l.replace("(","")
                                    
                                at = l.split('-')[0]
                                time = l.split('timerequired:')[1].split(',')[0]
                                success = l.split('successprobability:')[1].split(',')[0].replace(")","")
                                
                                
                                capabilities[r].append( Capability(at,time,success) )
                                
                                #e.g.
                                #robot = r
                                #atomic_tasks = [at1_move, at4_notify]
                                #time_required = [2,4]
                                #success_probability = [0.8,0.7]
                                atomic_tasks.append(l.split('-')[0])
                                time_required.append(l.split('timerequired:')[1].split(',')[0])
                                success_probability.append(l.split('successprobability:')[1].split(',')[0].replace(")",""))
                                # end capabilities of robot r
                                if ")" in l:
                                    i = len(lines) # JIC
                                    break
                                # ERROR if ")" not found
                                if i==len(lines)-1:
                                    raise RuntimeError("Error in fetching DSL robots' capabilities. Robot ",r)
                                    #print("Error in fetching DSL robots' capabilities. Robot ",r)
                        # add capabilities info
                        robots_tasksInfo[r] = [atomic_tasks,time_required,success_probability]
                        
                        rVel[r] = vel
                        rInitLoc[r] = loc
        #print('',robots_tasksInfo)
        
        '''Get instances'''
        robotsIDs = robots_tasksInfo.keys()
        robot_classes ={}
        
        for r in robotsIDs:
            robot_classes[r] = Robot(r,rVel[r],rInitLoc[r],capabilities[r])
        
        return robot_classes, robotsIDs
    
        