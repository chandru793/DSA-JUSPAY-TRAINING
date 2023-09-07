s="chandruchan"
arr=list(s)
map={}

for c in arr:
    if c in map:
        map[c]+=1
    else:
        map[c]=1

for key,value in map.items():
    print(key," - ",value)