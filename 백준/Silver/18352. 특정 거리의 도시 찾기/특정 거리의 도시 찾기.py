from collections import deque

def dijk(n):
    q = deque()
    q.append((n,0))
    visited[n] = True

    while q:

        vn, vv = q.popleft()
        if vv == K:
            answer.append(vn)

        for v in graph[vn]:
            if not visited[v]:
                visited[v] = True
                q.append((v, vv+1))

N, M, K, X = map(int, input().split())
visited = [0]+[0]*N
graph = [[] for _ in range(N+1)]
for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
answer = []
dijk(X)
cnt = 0
if answer:
    answer.sort()
    for i in answer:
        print(i)
else:
    print(-1)