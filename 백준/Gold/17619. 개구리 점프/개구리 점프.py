import sys
input = sys.stdin.readline

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

start, end, value, idx = lst[0]
for v in range(1,N):
    n_start, n_end, n_value, n_idx = lst[v]
    # 겹치면
    if start<=n_start<=end:
        union(idx, n_idx)
        if n_end >= end:
            start, end, value, idx = n_start, n_end, n_value, n_idx
    else:
        start, end, value, idx = n_start, n_end, n_value, n_idx


for _ in range(Q):
    s, e = map(int, input().split())
    if p[s-1] == p[e-1]:
        print(1)
    else:
        print(0)