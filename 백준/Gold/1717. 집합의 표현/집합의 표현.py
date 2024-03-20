import sys
sys.setrecursionlimit(1000000)
input = sys.stdin.readline

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

p = [i for i in range(N + 1)]

for _ in range(M):
    v, a, b = map(int, input().split())

    if v == 0:  # union
        union(a, b)
    else:  # find
        if find(a) == find(b):
            print('YES')
        else:
            print('NO')