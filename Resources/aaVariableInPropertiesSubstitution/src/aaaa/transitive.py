#Finite binary AbstractRelationshipLoader



def booleanmatrix(a):
    
    m = []
    
    for i in a.keys():
        for j in a[i]:
            print(j)
        
    print(a)
    
    
    
    
consec = ['t1','t2']



r1 = ['t1','t2','t3']
r2 = ['t1','t2']
r3 = ['t2','t3']
r4 = ['t2','t3']
r5 = ['t3']

dic = {'r1':r1,'r2':r2,'r3':r3,'r4':r4,'r5':r5}

print("hi")

booleanmatrix(dic)

    