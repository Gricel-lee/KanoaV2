'''
Get transitive closure of a Alloy output allocation file
If "save_data" is True, it saves data about the alloy allocation model
and the cluster of robots from the  transitive closure.

Inputs example:
fileAllocation = "Alloyallocation1.xml"
fileAlloyModel = "modelAllocation.als"
fileTasksInput = ".mydsl"

Author: Gricel Vazquez 31/03/2022
'''

from auxiliary.printString import printIt2

def PrintAllocationInfo(p,a):
    
    '''
    Get transitive closure of a Alloy output allocation file
    If "save_data" is True, it saves data about the alloy allocation model
    and the cluster of robots from the  transitive closure.
    
    Inputs example:
    fileAlloy = "Alloyallocation1.xml"
    fileAlloyModel = "modelAllocation.als"
    fileDSL = ".mydsl"
    
    '''

    # 1) get dataframe with task tree
    printIt2(p.dfTasks)
    ''' Get dataframe with DSL info
        e.g.:
    
                     id      type robots tasks ordered consecutive  joint
        0    ct1_clean   compound    NaN   NaN   False       False    NaN
        1  ct2_patient   compound    NaN   NaN    True       False    NaN
        2     at1_move     atomic     2    NaN     NaN         NaN   True
        3    at2_floor     atomic     1    NaN     NaN         NaN  False
        4    at3_sanit     atomic     1    NaN     NaN         NaN  False
        5   at4_notify     atomic     1    NaN     NaN         NaN  False
    '''
    
    
    printIt2(a.dfAllocation)
    '''Get 
           id parent    ordered_children    location    runbyrobot  joint ordered consecutive   
    0    t4$0     NA           ['ct2$0']      NaN         NaN  NaN     NaN        NaN
    1    t2$0     NA           ['ct1$2']      NaN         NaN  NaN     NaN        NaN
    2    t3$0     NA           ['at3$0']      NaN         NaN  NaN     NaN        NaN
    3    t1$0     NA           ['ct1$1']      NaN         NaN  NaN     NaN        NaN
    4   ct2$0   t4$0  ['at4$0', 'ct1$0']      NaN         NaN  NaN     True       True
    5   ct1$2   t2$0  ['at1$0', 'at2$0']      NaN         NaN  NaN     False      True
    6   at3$0   t3$0                 NaN      l9 ['r4$0','r3$0']True   NaN        NaN
    7   ct1$1   t1$0  ['at1$1', 'at2$1']      NaN         NaN  NaN     False      True
    8   at4$0  ct2$0                 NaN      l10    ['r2$0']  NaN     NaN        NaN
    9   at2$2  ct1$0                 NaN      l13    ['r2$0']  NaN     True       True    
    10  at1$2  ct1$0                 NaN      l9     ['r2$0']  NaN     NaN        NaN...
    '''

    # 3) get transitive closure - (cluster of robots sharing constraints)
    printIt2(a.robotclusters)
    
    printIt2('\nTransitive closure done.')
    return

