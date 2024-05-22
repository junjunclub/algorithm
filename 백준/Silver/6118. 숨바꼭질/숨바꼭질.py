from collections import deque

def bfs():
    q = deque()
    q.append(1)
    visited[1] = 1

    while q:
        v = q.popleft()

        for next in graph[v]:
            if not visited[next]:
                visited[next] = visited[v]+1
                q.append(next)



N, M = map(int, input().split())
visited = [0]*(N+1)
graph = [[] for _ in range(N+1)]
for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

bfs()
max_num = max(visited)
max_cnt = visited.count(max_num)
num = 0
for i in range(N+1):
    if visited[i] == max_num:
        num = i
        break
print(num, max_num-1, max_cnt)