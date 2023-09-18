import os
from auxiliary.utility import isConstrained
from classes.allocation import Allocation



def create_PROP_file(c,a):
    '''Create EvoChecker/PRISM .props file'''
    
    #s+=("label \"done\" = done;\n")
    for perm in c.perm_robot_task:
        s=""
        
        f1 = c.nameFilePMProps(perm,"propFeas")
        with open(f1, 'w') as f:
            # Check if feasible, result to this should be = 1
            s = "Pmax=?[F done]"
            #print(s)
            f.write(s)
        
        f2 = c.nameFilePMProps(perm,"propP")
        with open(c.nameFilePMProps(perm,"propP"), 'w') as f:
            # Minimise probability of failure
            s = "Pmin=? [ G ("
            for r in c.cluster:
                s +=  "{}_fail=0 & ".format(r)
            s = s[:-3] + ") ]"
            #print(s)
            f.write(s)
            
        f3 = c.nameFilePMProps(perm,"propI")
        with open(f3, 'w') as f:
            # Minimise idling
            s = "R{\"idle\"}min=? [ F done ]"
            f.write(s)
        
        f4 = c.nameFilePMProps(perm,"propT")
        with open(f4, 'w') as f:
            # Minimise travelling
            s = "R{\"travel\"}min=? [ F done ]"
            #print(s)
            f.write(s)
    return f1,f2,f3,f4



