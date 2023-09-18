'''
Capability class.
- tasks tree
- tasks allocation
- clusters of robots (transitive closure)
    
Author: Gricel Vazquez 22/05/2022
'''


class ConstrainedTask():
    ''' Get compound tasks consec/order constrained
    input combinations: (not) ordered / (not) consecutive, e.g.: 
    consecutive = False      #must be ==True/False otherwise detects NaN as well
    ordered = True           #must be ==True/False otherwise detects NaN as well
    '''
    
    
    def __init__(self,a,dict_df):
        
        self.idInAllocation =  dict_df["id"] #id in allocation = id + "_" + number
        self.parent =   dict_df["parent"]
        self.children = eval(dict_df["ordered_children"])
        self.ordered =  dict_df["ordered"]
        self.consecutive = dict_df["consecutive"]
        self.location = dict_df["location"]
        self.allocation = a
        self.atomicChildren = self.getCT_all_ATsubtasks(self.idInAllocation, a)
        self.num_atomicChildren = len(self.atomicChildren)
    
            
    def getCT_all_ATsubtasks(self,ct,a):
        '''Get all necessary atomic tasks for a compound task, recursively'''
        stack = [ct] 
        at = []
        dfAllocation = a.dfAllocation
        # in case used for an at, just return the at
        if a.isAtomic(ct):
            return [ct]
        
        while stack: # for children, recursively
            #print('stack:',stack)
            # get next task
            tid = stack.pop()
            # if atomic, just append
            if a.isAtomic(tid):
                at.append(tid)
            else:
                # get children
                c = dfAllocation.loc[dfAllocation['id']==tid]['ordered_children'].values.item()
                children = eval(dfAllocation.loc[dfAllocation['id']==tid]['ordered_children'].values.item())
                #print(tid,' children: ',children)
                # add children at the beggining 
                stack = children + stack 
        #print('at of ',ct," are: ",at)
        return at
    