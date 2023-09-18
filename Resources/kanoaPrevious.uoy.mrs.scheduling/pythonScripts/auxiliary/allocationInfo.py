'''
This file contains functions required by transitive_closure.py
to get allocation info from each Alloy Analyzer .xml output.

Author: Gricel Vazquez 31/03/2022
'''
import os
import pandas as pd
import xml.etree.ElementTree as ET

def getAlloyAllocation(fileMissionTree,fileAllocation):
    
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

    # .txt file with dsl info= ['id', 'parent','ordered_children','location','runbyrobot','joint','ordered','consecutive']
    df = pd.read_csv(fileMissionTree,sep=",,",engine ='python', skip_blank_lines=True) #need engine=python when separator is more than one character
    # add robots from alloy allocation
    df = _add_robots_to_df(df,fileAllocation) 
    
    #for index,row in df.iterrows():
    #    print(row)
        
    return df


def _add_robots_to_df(df,fileAlloy):
    '''Add robots assigned to atomic tasks into the allocation dataframe "df" '''
    #get robots
    at_to_robot = _getRobotsAssignedToTasks(fileAlloy)
    #print(at_to_robot)
    for i in at_to_robot.keys():
        df.loc[df.id==i,'runbyrobot']= str(at_to_robot[i]).replace(" ", "")
        #print("Row with robots: ", df.loc[df.id==i] )
    return(df)


def _getRobotsAssignedToTasks(fileAlloy):
    '''Read Alloy allocation and get atomic tasks and their assigned robot(s).'''
    # get robot allocated
    etree = ET.parse(os.path.abspath(fileAlloy))
    instance = etree.getroot()[0] #command>alloy
    at_to_capab = {}
    
    
    #at_to_capab
    for child in instance:
        if (child.tag=="field") & (child.attrib["label"]=="do"):
            # Capability running task
            for tuplee in child:
                try:
                    # get alloy info
                    capability = tuplee[0].attrib["label"].split("$")[0].replace(" ", "")
                    atomic_task = tuplee[1].attrib["label"].split("$")[0].replace(" ", "")
                    
                    # add to dictionary
                    if (atomic_task in at_to_capab.keys()): #if it exist
                        at_to_capab[atomic_task].append(capability)
                    else:
                        at_to_capab[atomic_task] = [capability]
                except:pass
    #print(at_to_capab)
    
    #cap_to_capab
    cap_to_robot = {}
    for child in instance:
        if (child.tag=="field") & (child.attrib["label"]=="capability"):
            # Capability belongs to robot x
            for tuplee in child:
                try:
                    robot = tuplee[0].attrib["label"].split("$")[0]
                    capability = tuplee[1].attrib["label"].split("$")[0]
                    # add in dictionary
                    cap_to_robot[capability] = robot
                except:pass
    #print(cap_to_robot)

    at_to_robot = {}
    for at in at_to_capab.keys():
        for cap in at_to_capab[at]: # joint atomic tasks may have more than one cap robot
            if at in at_to_robot.keys():
                at_to_robot[at].append( cap_to_robot[cap] )
            else:
                at_to_robot[at] = [cap_to_robot[cap]]
    #at1_move_0
    
    #print(at_to_robot)     
    
    return(at_to_robot)

