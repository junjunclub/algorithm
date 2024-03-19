from collections import deque

def bfs(r, c):
    Q = deque()
    Q.append((r,c))

    visited[r][c] =1

    while Q:
        vr, vc = Q.popleft()

        for dr, dc in [(0,1),(0,-1),(1,0),(-1,0)]:
            newR = dr+vr
            newC = dc+vc
            if 0<=newR<N and 0<=newC<M:
                if not visited[newR][newC] and lst[newR][newC]:
                    Q.append((newR,newC))
                    visited[newR][newC] = 1
                if lst[newR][newC] == 0:
                    ice[vr][vc] += 1


N, M = map(int, input().split())
lst = [list(map(int, input().split())) for _ in range(N)]

period = 0
while True:
    cnt = 0
    visited = [[0] * M for _ in range(N)]
    ice = [[0] * M for _ in range(N)]
    for i in range(N):
        for j in range(M):
            if lst[i][j] and not visited[i][j]:
                bfs(i,j)
                cnt += 1
    if cnt > 1:
        break

    zerocnt = 0
    for a in range(N):
        for b in range(M):
            lst[a][b] -= ice[a][b]
            if lst[a][b] <= 0:
                lst[a][b] = 0
                zerocnt += 1
    if zerocnt == M*N:
        period = 0
        break
    period += 1
print(period)