'''
Allocation class.
- tasks tree
- tasks allocation
- clusters of robots (transitive closure)
    
Author: Gricel Vazquez 22/05/2022
'''
from more_itertools import nth_permutation
from classes.allocation import Allocation
from classes.problemSpecification import ProblemSpecification


class Permutation():
    
    def __init__(self,p:ProblemSpecification, a:Allocation, rID:str , perm_num): 
        

        self.robot = rID
        
        self.allocation = a
        
        self.perm_num  = perm_num
        
        self.tasks = self.getTasksInPermutation(p,a) #e.g. ['r5_at1_move_0', 'r5_at1_move_1']
        
        
        #DEPRICATED
        #self.isItFeasible, self.violated_ordered_ct = self.check_if_possible();
        
        #DEPRICATED
        #self.num_r_perm = a.permutationArray[rID]
        
    
    def getTasksInPermutation(self,p,a):
        dfP = p.dfPermutations
        df = dfP.loc[(dfP["allocation"]==a.num) & (dfP["num_perm"]==self.perm_num) & (dfP["robot"]==self.robot)]
        tasks = eval(eval(df.iloc[0]["permutation"]))
        # generic tasks
        gen_tasks = []
        for t in tasks:
            #print(t) # e.g. r1_at4_notify_2   r1_at4_notify_8 r1_at3_sanit_10 r1_at2_floor_9 r1_at4_notify_5 r1_at2_floor_12 r1_at3_sanit_13 r1_at3_sanit_7 r1_at2_floor_6
            gen_tasks.append(t.split("_",1)[1])
        
        return gen_tasks
        
    
    #DEPRICATED
    def DEPRICATEDgetTasksPermutation(self):
        tasks = self.allocation.get_rtasks_FromDatabase(self.robot)
        
        perm = nth_permutation(tasks, len(tasks), self.num_r_perm)
        
        #perm = list(itertools.permutations(tasks))[self.num_r_perm]
        return perm
    
    
    #DEPRICATED
    def DEPRICATEDcheck_if_possible(self):
        isItFeasible = True
        violated_ordered_ct = []
        '''Check ordering constraints'''
        # for each atomic task assigned to the robot (in the ordered given by the permutation) 
        #print("Robot has tasks", self.tasks)
        for at_check in self.tasks:
            #print("Checking ",at_check)
            for ct in self.allocation.orderedTasks:
                ct_listAT = ct.atomicChildren
                #print('in ct: ',ct_listAT)
                
                # if first in list, no order required
                if at_check in ct_listAT[0]:
                    #print("First in list, so ok")
                    indx = 0 # dummy
                # if in list, get 
                elif at_check in ct_listAT:
                    # get at tasks coming after t_i in permutations 
                    indx = self.tasks.index(at_check)
                    permutation_tasks_after_ti = self.tasks[indx+1:]
                    
                    #print("Task after t in perm: ",permutation_tasks_after_ti)
                    
                    # get tasks that MUST be done before t_i
                    indx = ct_listAT.index(at_check)
                    tasks_must_be_done_before = ct_listAT[:indx] 
                    
                    # check that none of the tasks coming after shoud have been done before
                    L1 = permutation_tasks_after_ti
                    L2 = tasks_must_be_done_before
                    l = len([i for i in L1 if i in L2])
                        
                    if l!=0:
                        isItFeasible = False
                        #print("THE ORDERING IS UNFEASIBLE")
                        violated_ordered_ct.append(ct)
                # else: task is not in CT subtasks 
        return isItFeasible , violated_ordered_ct