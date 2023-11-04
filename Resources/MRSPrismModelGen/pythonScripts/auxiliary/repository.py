from builtins import set
import os
from auxiliary import utility

def _checInRepo(setAlloc,dfRepo):
    '''Check if this allocation (set) robot-tasks has already been
    translated to EvoChecker
     '''
    return setAlloc in dfRepo.SetOfAlloc.values
    
        
def _rtasks(r,df):
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
        locids =  df_r['location']
        tasks_rename, tasks, tasksLocations = [],[],[]
        set_rename = {}
        for i,iloc in zip(taskids,locids):
            tasks.append(i) #only list of tasks
            tasks_rename.append(r+"_"+i) #rename as roboti_taskij
            tasksLocations.append(iloc)
        #print("Tasks of "+r+": "+str(tasks))
        #print("Tasks renamed of "+r1+": "+str(tasks_rename)) #replaced "'" and "$"
        return(tasks,tasks_rename,tasksLocations)

def add2Repo(cluster,dfAllocation,dfRepo): # for each cluster safe a row 
    setAlloc = set()
    tasks, tasks_rename, tasksLocations = [],[],[]
    for r in cluster:
        a,b,c = _rtasks(r,dfAllocation)
        tasks.append(a) # append to separate lists of tasks for each robot in the cluster 
        tasks_rename.append(b)
        tasksLocations.append(c)
        setAlloc.update(b) # allocation set
    # check if already in repo: 'SetOfAlloc','ListAlloc','Robots','Tasks','ListLoc'
    if not _checInRepo(setAlloc,dfRepo):
        dfRepo = dfRepo.append({'SetOfAlloc': setAlloc ,
                            'ListAlloc': tasks_rename,
                            'Robots': cluster,
                            'Tasks': tasks,
                            'ListLoc': tasksLocations}, ignore_index=True)
    return(dfRepo)



def update_repository(dfAllocation,dfRepo,allclusters):
    '''Get unique combination of robots to tasks
    columns: 'SetOfAlloc','ListAlloc','Robots','Tasks','ListLoc'
    '''
    for cluster in allclusters:
        dfRepo = add2Repo(cluster,dfAllocation,dfRepo)
    return dfRepo


