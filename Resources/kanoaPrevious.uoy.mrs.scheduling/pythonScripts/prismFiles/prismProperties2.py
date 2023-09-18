import os
from auxiliary.utility import isConstrained
from classes.allocation import Allocation



def create_PROP_file(c,a):
    '''Create EvoChecker/PRISM .props file'''
    
    #s+=("label \"done\" = done;\n")
    for perm in c.perm_robot_task:
        s=""
        with open(c.nameFilePMProps(perm,"props"), 'w') as f:
            # Minimise probability of failure
            probmin = "\nPmin=? [ G ("
            for r in c.cluster:
                probmin +=  "{}_fail=0 & ".format(r)
            probmin = probmin[:-3] + ") ]"
        
            prob_max=True
            idle=True
            travel=True
            if prob_max:
                s += probmin#"\nP=? [ F \"done\" ]" 
            if idle:
                s += "\n\nR{\"idle\"}min=? [ F done ]"
            if travel:
                s += "\n\nR{\"travel\"}min=? [ F done ]"
                
            s = "multi(R{\"travel\"}min=?[F done], R{\"idle\"}min=?[F done], " + probmin[1:] + ")"
            #print(s)
            f.write(s)
            
    return
        
###### DEPRICATED
def DEPRICATEDcreate_PROP_file(c,a):
    '''Create EvoChecker/PRISM .props file'''
    s=""
    #s+=("label \"done\" = done;\n")
    with open(os.path.abspath(c.fileprops), 'w') as f:
        tordered_formula = ordered_formulae(a.dfAllocation)
        
        
        
        # Minimise probability of failure
        probmin = "\nPmin=? [ G ("
        for r in c.cluster:
            probmin +=  "{}_fail=0 & ".format(r)
        probmin = probmin[:-3] + ") ]"
        
        #### solve ordering later!!
        tordered_formula=[] # for now...
        
        if tordered_formula==[]: # no ordered tasks
            if prob_max:
                s += "//Objective, min" #s += "// maximisation [0..R+]" ??
                s += probmin#"\nP=? [ F \"done\" ]" 
                s += "\n\n"
            if idle:
                s += "//Objective, min"
                s += "\nR{\"idle\"}=? [ F done ]"
                s += "\n\n"
            if travel:
                s += "//Objective, min"
                s += "\nR{\"travelDistance\"}=? [ F done]"
                s += "\n\n"
        else:  # with ordered tasks
            if prob_max:
                s += "//Objective, max"
                s += probmin[:-1] + "& ({}) ]".format(tordered_formula) #"\nP=? [ (F \"done\") & ({}) ]".format(tordered_formula)
                s += "\n\n"
            if idle:
                s += "//Objective, min"
                s += "\nR{\"idle\"}=? [ (F done) & ({}) ]".format(tordered_formula)
                s += "\n\n"
            if travel:
                s += "//Objective, min"
                s += "\nR{\"travelDistance\"}=? [ (F done) & ({}) ]".format(tordered_formula)
                s += "\n\n"
        f.write(s)
    return
    



