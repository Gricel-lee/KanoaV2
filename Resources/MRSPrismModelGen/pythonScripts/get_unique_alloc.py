import os
import pandas as pd
import auxiliary.repo
import prismFiles.prismProperties
from classes.cluster import Cluster 
from classes.allocation import Allocation
from auxiliary.printString import printIt2
from classes.problemSpecification import ProblemSpecification

        
def GetUniqueAlloc(p,a):
    '''p.uniqueClusterAlloc = ['allocid','num_cluster','uniqueAlloc','reference']    ...'''
    uniqueClusterAlloc = p.getuniqueClusterAlloc()
    
    isUniqueAlloc = False
    
    for num_cluster in range(0,a.getNumClusters()):
        # get cluster
        cluster = a.robotclusters[num_cluster]
        
        # 1) check if allocation already created
        inrepo,setAlloc,alloc_num,num_cluster_ref = auxiliary.repo.checkRepo(p,a,cluster)
                
        # 2) add to current repository and create EvoChecker file
        if inrepo==False:
            isUniqueAlloc = True # return unique if at least one cluster is different
            uniqueClusterAlloc = pd.concat([uniqueClusterAlloc,
                    pd.DataFrame.from_records([{'allocid':a.num,
                                                'num_cluster':num_cluster,
                                                'uniqueAlloc':setAlloc}])])
            
        else:  # if already in repository, just add reference
            
            printIt2(str(a.num)+" is in repo")
            uniqueID_alloc_clust =  alloc_num+"_"+num_cluster_ref # point to existing file
            uniqueClusterAlloc = pd.concat([uniqueClusterAlloc,
                    pd.DataFrame.from_records([{'allocid':a.num,
                                                'num_cluster':num_cluster,
                                                'reference':uniqueID_alloc_clust}])])            
    
    p.uniqueClusterAlloc = uniqueClusterAlloc
    return p,isUniqueAlloc

