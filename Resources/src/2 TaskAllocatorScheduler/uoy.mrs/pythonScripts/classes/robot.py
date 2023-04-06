from auxiliary import utility
import sys

class Robot():
    '''Robot class, associated to a problem specification'''
    def __init__(self,r,vel,rInitLoc,capabilities):
        
        # robot ID
        self.id = r
        # velocity (integer part)
        self.velocity = vel;
        # initial location id of robot r
        self.init_loc = rInitLoc;
        # capabilities
        self.capabilities = capabilities
        # dictionary capabilities
        self.capabilities_at =  self.get_cap_dic()
    
    
    def get_cap_dic(self):
        cap = {}
        
        for c in self.capabilities:    
            cap[c.atomicTask] = c.success
        return cap
        
    
    # prob = p.robot_classes[r].getProb4Task(t)
    def getTimeInt4Task(self,at,a):
        time = self.getTime4Task(at,a)
        return int(eval(time))
    
    
    def getTime4Task(self,at,a):
        time = ""
        for cap in self.capabilities:
            if cap.atomicTask == at:
                time = cap.time
        # if not found, try removing allocation
        if time=="":
            at = a.get_task_generic(at)
            for cap in self.capabilities:
                if cap.atomicTask == at:
                    time = cap.time
                    
        if time=="":
            sys.exit('ERROR getting atomic task time.')
        return time
    
    def getProb4Task(self,at):  
        prob = ""
        #print('checking at ',at)
        
        #for cap in self.capabilities:
        #    print('CAPABILITIES:', cap.atomicTask)
        
        for cap in self.capabilities:
            #print('in cap:', cap.atomicTask)
            if cap.atomicTask == at:
                prob = cap.success
            
            print("This" , prob)
            
            return prob
        # if not found, try removing allocation
        if prob=="":
            at = utility.get_task_generic_fromAllocation(at)
            
            #print('now checking at ',at)
            
            for cap in self.capabilities:
                #print('in cap:', cap.atomicTask)
                if cap.atomicTask == at:
                    prob = cap.success
            
            return prob
        
        raise 'Error, no task found'
    
    