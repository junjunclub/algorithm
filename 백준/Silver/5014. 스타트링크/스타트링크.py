from collections import deque

def bfs(n):
    q=deque()
    q.append(n)
    visited[n] = 1

    while q:
        v = q.popleft()
        if v == G:
            return visited[v]-1

        for vv in [(v+U),(v-D)]:
            if 1<=vv<=F and not visited[vv]:
                q.append(vv)
                visited[vv] = visited[v]+1
    return 'use the stairs'
F, S, G, U, D = map(int, input().split())
visited = [-1]+[0]*F
print(bfs(S))