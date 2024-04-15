def find(x):
    if p[x] != x:
        p[x] = find(p[x])
    return p[x]

def union(x, y):
    x = find(x)
    y = find(y)

    if x == y:
        return

    p[y] = x

N, Q = map(int, input().split())
p = [i for i in range(N)]
lst = []
for i in range(N):
    x1, x2, y = map(int, input().split())
    lst.append((x1,x2,y,i))
lst.sort()
for v in range(1,N):
    if lst[v-1][1] >= lst[v][0]:
        union(lst[v-1][3],lst[v][3])


for _ in range(Q):
    s, e = map(int, input().split())
    if p[s-1] == p[e-1]:
        print(1)
    else:
        print(0)