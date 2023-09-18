import pandas as pd
from auxiliary import utility
from auxiliary.printString import printIt2


######## Check this, it may be deprecated all of this

def checkRepo(p,a,cluster):
    ''' Returns:
    check - True if it already existed in repoList    
    '''
    uniqueClusterAlloc = p.getuniqueClusterAlloc()
    # list of robot-tasks sets
    repoList = uniqueClusterAlloc['uniqueAlloc'].tolist()
    
    # new set to check
    setAlloc = set()
    
    tasks, tasks_rename, tasksLocations = [],[],[]
    for r in cluster:
        b = _rtasks(r,a)
        tasks_rename.append(b)
        setAlloc.update(b) # allocation set
    # check if already in repo
    
    # not in repo (defauld)
    check = False
    allocid_ref = -1 # reference to repo
    num_cluster_ref = -1 # reference to repo
    # in repo
    if setAlloc in repoList:
        check = True # in the repo
        #check where is the alloc
        i = repoList.index(setAlloc)
        #get allocID
        allocid_ref = str(uniqueClusterAlloc.iloc[i]['allocid'])
        #get num_cluster
        num_cluster_ref = str(uniqueClusterAlloc.iloc[i]['num_cluster'])
        
    return(check,setAlloc,allocid_ref,num_cluster_ref)

    
def _rtasks(r,a):
        df = a.dfAllocation
        '''Find tasks for robot r'''
        # (needed to look for robot)
        d1 = df[df['runbyrobot'].apply(lambda x: isinstance(x, str))] #rows that have "runbyrobot" (i.e., str type in df)
        r1 = "\'"+r+"\'" #add quotations to look for robot in string, JIC
        row_index_with_r =[] #df rows with robot r
        
        # look for specific robot r
        for i,count in zip(d1['runbyrobot'],d1.index):
            #print(count,"  ",i,type(i),i[1])
            if r1 in i:
                row_index_with_r.append(count)
        df_r = df.iloc[row_index_with_r]
        #print('robot ',r1, ' in ',df_r)
        
        taskids = df_r['id']
        tasks_rename = []
        set_rename = {}
        for i in taskids:
            tasks_rename.append(r+"_"+i) #rename as roboti_taskij
        #print("Tasks renamed of "+r1+": "+str(tasks_rename)) #replaced "'" and "$"
        return(tasks_rename)
    
    





