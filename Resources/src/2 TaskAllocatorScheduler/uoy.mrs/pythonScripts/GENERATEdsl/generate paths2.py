n = 5

from math import sqrt,ceil # import square root from the math module
          
def distance(p1, p2): # simple function, I hope you are more comfortable
  r= sqrt((p1[0]-p2[0])**2+(p1[1]-p2[1])**2) # Pythagorean theorem
  return ceil(r)
  
robX = n//3
print("l1 : ( x {}.0 y 0.0 ) //robot1".format(robX))


for i in range(1,n+1):
    print("room{} : ( x {}.0 y 1.0) //room{}".format(i,i,i))

print("//paths")

for i in range(1,n+1):
    pointA = (robX,0)
    pointB = (i-1,1)
    d = distance(pointA,pointB)
    print("l1 to room{}, distance {}.0".format(i,d))

for room1 in range(1,n+1):
    for room2 in range(1,n+1):
        
        pointA=(room1-1,1)
        pointB=(room2-1,1)
        d = distance(pointA,pointB)
        if room1!=room2:
            print("room{} to room{}, distance {}.0".format(room1,room2,d))
