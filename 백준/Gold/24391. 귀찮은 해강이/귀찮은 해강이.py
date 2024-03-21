import sys
input=sys.stdin.readline

def find(x):
    if p[x] != x:
        p[x] = find(p[x])
    return p[x]

def union(x, y):
    x = find(x)
    y = find(y)

    if x < y:
        p[y] = x
    else:
        p[x] = y

N, M = map(int, input().split())
p = [i for i in range(N+1)]
move = 0
for _ in range(M):
    a, b = map(int, input().split())
    union(a, b)
lst = list(map(int, input().split()))
for j in range(1,len(lst)):
    if find(lst[j]) != find(lst[j-1]):
        move += 1
print(move)