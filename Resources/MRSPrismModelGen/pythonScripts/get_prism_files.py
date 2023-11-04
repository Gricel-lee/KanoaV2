import prismFiles.prismFile
from classes.cluster import Cluster 
from classes.allocation import Allocation
from classes.problemSpecification import ProblemSpecification



def CreatePrismFiles(a,p,perm_num):
    
    # Create MDP for each cluster
    for num_cluster in range (0,len(a.robotclusters)):
        
        # create cluster
        c = Cluster(p,a,num_cluster,perm_num)
        # MDP
        _createPM(a,p,c)
        


def _createPM(a:Allocation,p:ProblemSpecification,c:Cluster):
    '''Create an prismChecker file for each unique TC (transitive closure).'''
    # 1) create PM
    prismFiles.prismFile.create_MDP_files(a,p,c)
    return

