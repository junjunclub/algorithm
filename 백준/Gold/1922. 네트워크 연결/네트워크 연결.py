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

N = int(input())
M = int(input())
p = [i for i in range(N+1)]
edges = []
for _ in range(M):
    s, e, w = map(int, input().split())
    edges.append((w, s, e))
edges.sort()
# print(edges)
answer = 0
for w, s, e in edges:
    if find(s) != find(e):
        union(s, e)
        answer += w
print(answer)