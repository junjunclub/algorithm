lst = [0]*31
for _ in range(28):
    n = int(input())
    lst[n] = 1
for a in range(1,len(lst)):
    if lst[a] == 0:
        print(a)