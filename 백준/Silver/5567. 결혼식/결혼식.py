def dfs(lev, start):
    if lev == 2:
        return

    visited[start] = True

    for v in graph[start]:
        visited[v] = True
        dfs(lev + 1, v)


N = int(input())
M = int(input())
graph = [[] for _ in range(N + 1)]
visited = [0] * (N + 1)
cnt = 0
for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
# print(graph)
dfs(0, 1)
print(sum(visited)-1)
