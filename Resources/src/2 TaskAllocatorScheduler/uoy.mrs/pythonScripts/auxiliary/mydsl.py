'''
This file contains functions required by transitive_closure.py
to get task tree info from DSL .mydsl file.

Author: Gricel Vazquez 31/03/2022
'''
import pandas as pd

def getTasksDF(fileDSL:str="file1.mydsl"):
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
    dfcols = ['id','type','robots','tasks','ordered','consecutive','joint']#,'duration','location'
    df = pd.DataFrame(columns=dfcols)
    
    with open(fileDSL) as f:
        lines = f.readlines()
        for l in lines:            
            # if not a comment
            comment = True if l.strip().startswith("//") else False 
            if comment==False:
                
                # atomic tasks
                l = l.replace(" ","")
                
                if "robotsneeded" in l:
                    
                    at = l.split(":")[0]
                    
                    robots = l.split("robotsneeded")[0].split(":")[1]
                    
                    joint = "True" if int(robots)>1 else "False"
                    
                    df = pd.concat([df, pd.DataFrame.from_records([{'id': at,'type': "atomic",'robots': robots,'joint':joint}])])
                    # depricated
                    #df = df.append({'id': at,'type': "atomic",'robots': robots,'joint':joint}, ignore_index=True)
                
                # compound tasks 
                if "subtasks" in l:
                    ct = l.strip().split(':')[0].replace(" ", "")
                    ordered = "True" if "ordered:true" in l.strip() else "False"
                    consec = "True" if "consecutive:true" in l.strip() else "False"
                    
                    df = pd.concat([df, pd.DataFrame.from_records([{'id': ct,'type': "compound",'ordered':ordered,
                                    'consecutive':consec}])])
                    # depricated
                    #df = df.append({'id': ct,'type': "compound",'ordered':ordered,'consecutive':consec}, ignore_index=True)
    return(df)
