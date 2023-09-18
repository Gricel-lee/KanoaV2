import os
#from io.netty.handler.codec import string

class World():
    '''From generated file worldmodel.txt
    e.g.:
        l1,room3,3.0
        l1,room5,9.0
        l2,room3,9.0
        l2,room5,2.0
        room3,room5,7.0
        room5,room3,7.0
        r1,l1   // already read directly from DSL in the problemSpecification class
        r5,l2
    '''
    def __init__(self,wm_file):
        self.fileWM = wm_file
        self.dic_dist = self._read_DSL_wm() # dictionary with distances between two locations
        
    
    def get_dist_loc1loc2(self,loc1,loc2):
        '''Get distance between two location IDs
        as an integer
        '''
        if loc1==loc2:
            return 0
        return int(eval(self.dic_dist[loc1,loc2]))
    

    def _read_DSL_wm(self):
        '''Read world model info worldmodel.txt
        returns robot to initial location
        and array of [loc1,loc2,distance]
        and a dict [(loc1,loc2)] = distance
        '''
        #dist = []
        dic_dist = {}
        
        try:
            with open(os.path.abspath(self.fileWM), 'r') as f:
                # remove empty lines
                lines = (line.rstrip() for line in f) # All lines including the blank ones
                lines = (line for line in lines if line) # Non-blank lines
                # read lines
                for line in lines:
                    v = line.split(',')
                    if len(v)==3: # distance between two locations [loc1,loc2,dis]
                        #dist.append(v)
                        dic_dist[(v[0],v[1])] = v[2]
        except BaseException as err:
            raise RuntimeError('Error reading worldmodel.txt file.',err)
        else:
            return dic_dist#,dist

     