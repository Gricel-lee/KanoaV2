'''
Capability class.
- tasks tree
- tasks allocation
- clusters of robots (transitive closure)
    
Author: Gricel Vazquez 22/05/2022
'''


class Capability():
    
    def __init__(self,at,time,success):
        self.atomicTask = at
        self.time = time
        self.success = success