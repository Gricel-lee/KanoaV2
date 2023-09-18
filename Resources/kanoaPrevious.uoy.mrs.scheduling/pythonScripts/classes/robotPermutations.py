import auxiliary 
import os
from numpy.random.mtrand import permutation

class RobotPermutations():
    '''String ID of robot and list of permutations'''
    def __init__(self,r,tasks,id):
        #pm file
        self.filepm = os.path.abspath(p.path_evo + "/"+self.uniqueID_alloc_clust+"PM"+".pm")
        # robot id
        self.robot = r
        # list of permutations (list of tasks)
        self.permutations = []
        
    def add_permutation(self,list_tasks):
        permutation.append(Permutation(self.robot , list_tasks))