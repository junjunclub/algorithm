from collections import deque

def check(v):
    answer = []
    tmp = v

    for _ in range(visited[v]+1):
        answer.append(tmp)
        tmp = path[tmp]
    print(' '.join(map(str, answer[::-1])))

def bfs(n):
    q = deque()
    q.append(n)
    visited[n] = 0

    while q:
        v = q.popleft()

        if v == K:
            print(visited[v])
            check(v)
            return

        for next in [(v-1),(v+1),(2*v)]:
            if 0<=next<=100000 and visited[next] == 0:
                q.append(next)
                visited[next] = visited[v]+1
                path[next] = v


N, K = map(int, input().split())
visited = [0]*100001
path = [0]*100001
bfs(N)
