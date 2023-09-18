import auxiliary 
import re
import os
from classes.robot import Robot



class RobotssInfo():
    def __init__(self,p): #,fileDSL:str="file1.mydsl"
        # get initial locations, etc.
        self.robots_tasksInfo, self.rVel, self.rInitLoc = self._robotsDSLinfo(p.fileDSL)
        # all robots in database (dsl)
        self.robotsKeys = self.robots_tasksInfo.keys()
        # get instances of robot classes for all robots in DSL
        self.robot_classes = self._instanciate_robots()
        
    def getrobot_classes(self):
        return self.robot_classes
        
    def _instanciate_robots(self):
        robot_classes ={}
        for r in self.robotsKeys:
            robot_classes[r] = Robot(r,self.rVel,self.rInitLoc)
        return robot_classes
    
    def modify_robot_iallocation(self,a):
        '''Modifiable for each allocation'''
        for r in self.robotsKeys:
            self.robot_classes[r].robot_allocation(a) # get allocation info            
        return
        
    
    def _robotsDSLinfo(self,fileDSL):
        '''Get data from robots in the DSL file
           Robot completion times and probabilities of success from .mydsl
        
        e.g., robots_tasksInfo[r] = [atomic_tasks,time_required,success_probability]
        
        '''
        robots_tasksInfo= {}
        rVel = {}
        rInitLoc = {}
        
        with open(fileDSL) as f:
            lines = f.readlines()
            for i in range(0,len(lines)):       
                l = lines[i]    
                 
                # if not a comment
                comment = True if l.strip().startswith("//") else False 
                if not comment:
                    
                    # if a robot:      e.g. r5: at initial location l8 with capabilities c2,c3 can do
                    if "at initial location" in l:
                        r = l.strip().split(':')[0].replace(" ", "") #do not delete strip nor replace; only worked like this
                        #print("robot",r)
                        
                        try:
                            loc  = l.replace(' ','').split('atinitiallocation')[1].split('hasvelocity')[0]
                            
                            vel  = int(float(l.replace(' ','').replace("\n","").split('hasvelocity')[1]))
                        
                            #print('init location=',loc)
                            #print('init location=',vel)
                            
                        except Exception:
                            traceback.print_exc()
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
        return robots_tasksInfo, rVel, rInitLoc
    
    def _read_DSL_wm(self,fileWM):
        '''Read world model info worldmodel.txt
        returns robot to initial location
        and array of [loc1,loc2,distance]
        and a dict [(loc1,loc2)] = distance
        '''
        rloc = {}
        try:
            with open(os.path.abspath(fileWM), 'r') as f:
                # remove empty lines
                lines = (line.rstrip() for line in f) # All lines including the blank ones
                lines = (line for line in lines if line) # Non-blank lines
                # read lines
                for line in lines:
                    v = line.split(',')
                    if len(v)==2: # robot location [r,initloc]
                        #print(r,' robot at ',v[1])
                        rloc[v[0]]= v[1]
                    #if len(v)==3 then is the distance between two locations [loc1,loc2,dis]
                
        except BaseException as err:
            raise RuntimeError('Error reading worldmodel.txt file.',err)
        else:
            return rloc
        