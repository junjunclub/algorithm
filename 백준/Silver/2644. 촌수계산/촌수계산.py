def dfs(n, depth):
    global answer
    if n == y:
        answer = depth
        return

    visited[n] = 1
    for i in graph[n]:
        if not visited[i]:
            visited[i] = 1
            dfs(i, depth+1)
            visited[i] = 0

N = int(input())
x, y = map(int, input().split())
m = int(input())
graph = [[] for _ in range(N+2)]
visited = [0]* (N+2)
for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
answer = -1

dfs(x, 0)
print(answer)