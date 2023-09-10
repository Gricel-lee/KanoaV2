import sys
import os
import sys
import pandas as pd
from classes.problemSpecification import ProblemSpecification
from classes.allocation import Allocation
from classes.permutation import Permutation
import print_allocation
import get_unique_alloc
from auxiliary import utility
from auxiliary import repo
import matplotlib.pyplot as plt

import get_prism_files

import auxiliary 
'from pymoo.core import solution'

import csv


###  PART 1 - Clustering

def startClustering():
    '''
    Get probabilistic models in Prism language for each cluster of robots (under transitive closure)
    in each alloy task allocation file (generated by Alloy) 
    Inputs:
    1) sys.argv[1] = Constants.ALLOYOUTPUT_DIR  - path to Alloy output files
    2) sys.argv[2] = Constants.MISSIONSTREEFILE - .txt file with dataframe info 
    3) sys.argv[3] = Constants.DSLFILE          - specifications of the system in DSL
    4) sys.argv[4] = Constants.TRANSITIVECLOSURE_DIR    - save TC models here
    5) sys.argv[5] = Constants.EVOOUTPUT_DIR     - save evoChecker models here
    6) sys.argv[6] = Constants.TOTALTIME4PLAN
    7) If "save_data" is True, it saves data about the alloy allocation model
    and the cluster of robots from the  transitive closure.
    8) sys.argv[8] = Constants.WORLDTXTFILE      - file generated with paths and robots loc.
    
    Through out this code, we refer to:
    - a problem specification as "p"
    - an allocation as "a"
    - a cluster as "c"
    
    '''
    
    # 1) Get inputs from Java
    p = ProblemSpecification() # includes robots' instantiation and world model
    print("- unique allocations found and robot clusters:")
    
    # 2) Create necessary folders and clean Java input
    utility.flush_sys_streams() # delete input stream
    utility.create_folder_if_not_exist(p.path_tc)
    
    
    allocations = []
    
    # 3) For each Alloy allocation:
    for fileAlloy in p.getalloyFileswPath(): # for each file, create probabilistic model(s)
        ''' Get allocations'''
        # 3.1) Create allocation object, get Transitive Closure (TC) clusters + allocation info, including its clusters of robots (by transitive closure)
        a = Allocation(p,fileAlloy)
        
        # 3.3) get unique allocations //sometime Alloy gives two SAME allocations
        p,isUniqueAlloc = get_unique_alloc.GetUniqueAlloc(p,a)
        
        if isUniqueAlloc:
            allocations.append(a)
            # save Transitive Closure
            a.saveAllocation_n_TCInfo(p.getTransClosurePath())
            # print info
            print(a.num ," cluster(s):", a.robotclusters)
        else:
            if os.path.exists(a.fileAlloy):
                os.remove(a.fileAlloy)
            else:
                print("Repeated Allocation file does not exist: "+ a.fileAlloy)
            
    # 4) Save info
    p.saveAllocInfo() # save repository info
    p.saveDSLTasksInfo() #repo.safeAllocationsRepo(p.uniqueClusterAlloc,p.saveData(),p.getTransClosurePath())
    
    p.saveUniqueallocations(allocations)




###  PART 2 - MDP creation

def createMDP():
    """
    try:
        import pymoo
    except ImportError:
        sys.exit("Trying to install -- python -m pip install pymoo -- ")
        os.system('python -m pip install pymoo')
    import pymoo
    
    try:
        import more-itertools
    except ImportError:
        sys.exit("Trying to install -- conda install -c conda-forge more-itertools --")
        os.system('conda install -c conda-forge more-itertools')
    import more-itertools
    """
    
    
    # 1) Get inputs from Java
    p = ProblemSpecification() # includes robots' instantiation and world model
    p.permutationsFile = sys.argv[10]
    p.path_mdp = sys.argv[11]
    
    # 2) all allocations.csv file
    allAllocFile = sys.argv[12]
    
    
    # 3) get info on tasks with tasks must be done before
    file = p.fileMissionTree+"constraints" # temporary file
    with open(file,'r') as f:  # READ tasks to be done before each at
        p.at_beforeDir = eval(f.readline()) #e.g.: {'at1_move_0': set(), 'at1_move_1': set(), 'at4_notify_2': set(), 'at2_floor_3': {'at4_notify_2'}, 'at3_sanit_4': {'at2_floor_3', 'at4_notify_2'}, 'at4_notify_5': set(), 'at2_floor_6': {'at4_notify_5'}, 'at3_sanit_7': {'at4_notify_5', 'at2_floor_6'}, 'at4_notify_8': set(), 'at2_floor_9': {'at4_notify_8'}, 'at3_sanit_10': {'at2_floor_9', 'at4_notify_8'}, 'at4_notify_11': set(), 'at2_floor_12': {'at4_notify_11'}, 'at3_sanit_13': {'at4_notify_11', 'at2_floor_12'}}
    os.remove(file) # delete file
    
    
    # @DEPRICATED
    #allocFile = sys.argv[10]
    #genesRob = eval(sys.argv[12])
    #v = eval(sys.argv[13]) # convert to set if only one 
    #genesVal = (v,) if type(v) is int else v # in case only one gene (only one robot)
    
    # 4) Create necessary folders and clean Java input
    utility.flush_sys_streams() # delete input stream
    utility.create_folder_if_not_exist(p.path_mdp)
    
    # 4) get allocations
    dfP = pd.read_csv(p.permutationsFile,sep=",,",engine ='python', skip_blank_lines=True, quotechar='"')
    
    p.dfPermutations = dfP
    
    allocationIDs = dfP["allocation"].unique() # e.g.: ['Allocation1' 'Allocation10' 'Allocation2' 'Allocation3' 'Allocation4' 'Allocation5' 'Allocation6' 'Allocation7' 'Allocation8' 'Allocation9']
    
    # 5) Get MDPs
    # a) for each allocation
    for allID in allocationIDs:
        # a.1) alloc instance
        allocFile =  p.alloyAllocDir + "/{}.xml".format(allID)
        a = Allocation(p,allocFile)
        
        # b) for each permutation
        # b.1) get permutations in allocation i
        permNums = dfP[dfP["allocation"]==allID].num_perm.unique() # permutations found for allocation i, e.g.: [0 1 2 3 4 5 6 7 8 9]
        
        print(("... creating MDP for {}, permutations {}").format(allID,str(permNums)))
            
        for perm_num in permNums:
            
            #print(("...MDP for {}, permutation {}").format(allID,perm_num))
            get_prism_files.CreatePrismFiles(a,p,perm_num)
        
        
        #print("File  allocation: ",allocFile)
        # 4) create MDP files (for cluster-allocations)
        
        
        
        
        #a.saveAllocation_n_TCInfo(p.getTransClosurePath()) # done before, when 1st called python
        '''
        #@DEPRICATED
        # 5) permutation genes
        #a.setPermArray(genesRob,genesVal)
        # 6) check if permutation is possible
        feasible = True
        for r in a.allrobotsIDs:
            # If any robot has a non feasible permutation
            if Permutation(p,a,r,genesVal).isItFeasible ==False:
                #print("NOT FEASIBLE permutation for robot: ", perm.robot)
                feasible = False
        if feasible == False:
            print("Not feasible          (1)by a robot(s) permutation") # Printing this is required as it is checked by JAVA
        '''      
        
        
    
# ------------MAIN--------------------
if len(sys.argv)>9:
    if sys.argv[9] == "MDPCreate":
        createMDP()
    else:
        print("ERROR: please check inputs to Python when creating an MDP. 9th should be MDPCreate string.")
else:
    startClustering()