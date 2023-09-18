#import auxiliary 
import os
from numpy.random.mtrand import permutation
import itertools
import math

class RobotSchedule():
    
    def __init__(self,a,robotID,num):
        #
        self.allocation = a
        #
        self.tasksInOrder = self.setnSchedule(num)
        # 
        self.robot = robotID
        
    
    def getTasks(self):
        return self.tasksInOrder
    
        
    def setTasks(self,tasksInOrder):
        '''set order of tasks manually'''
        self.tasksInOrder = tasksInOrder
        
    def setnSchedule(self,num):
        ''''get nth permutation of tasks'''
        if num>math.factorial(num):
            print('ERROR: trying to get more permutations of tasks than possible.')
        #print('num',num)
        #print('all perm up to n:', list(itertools.permutations(self.tasks)))
        self.tasksInOrder = list(itertools.permutations(self.a.get_rtasks(robotID)))[num]
        