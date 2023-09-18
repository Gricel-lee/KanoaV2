from math import sqrt,ceil # import square root from the math module

def distance(p1, p2): # simple function, I hope you are more comfortable
  r= sqrt((p1[0]-p2[0])**2+(p1[1]-p2[1])**2) # Pythagorean theorem
  return ceil(r)
  

dic = {"l7" : (1.0, 1.0 ),
    "l8" : (2.0, 1.0 ),
    "l9" : (6.0, 7.0 ),
    "l10": (7.0, 7.0 ),
    "l11": (8.0, 7.0 ),
    "room1" : (2.0,3.0),
    "room2" : (1.0, 7.0 ),
    "room3" : (4.0, 1.0 ),
    "room4" : (10.0, 1.0),
    "room5" : (10.0, 5.0),
    "room6" : (9.0, 7.0 )
    }

for k1 in dic.keys():
    
    print("//paths {}".format(k1))
    
    for k2 in dic.keys():
        
        if k1!=k2 and k2[0]!="l":
                
            pointA = dic[k1]
            pointB = dic[k2]
            d = distance(pointA,pointB)
            
            print("{} to {}, distance {}.0".format(k1,k2,d))

