t = raw_input().strip().split()
n = int(t[0])
k = int(t[1])

inp = [int(x) for x in raw_input().strip().split()]
inp.sort()
f = True
for i in range(len(inp)-1):
    if inp[i] + inp[i+1] > k:
        print i+1
        f = False
        break
if f:
	print len(inp)