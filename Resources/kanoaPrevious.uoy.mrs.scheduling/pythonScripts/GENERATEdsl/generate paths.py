n = 3

print("l1 : ( x 0.0 y 0.0 ) //robot1")
for i in range(1,n+1):
    print("room{} : ( x {}.0 y 0.0) //room{}".format(i,i,i))

print("//paths")

for i in range(1,n+1):
    print("l1 to room{}, distance {}.0".format(i,i))

for room1 in range(1,n+1):
    for room2 in range(1,n+1):
        if room1!=room2:
            d = room1-room2
            if d<0:
                d = d*-1
            print("room{} to room{}, distance {}.0".format(room1,room2,d))