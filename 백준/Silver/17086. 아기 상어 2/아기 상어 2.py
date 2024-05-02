from collections import deque

def bfs(r,c):
    global max_V
    q = deque()
    q.append((r,c))
    visited = [[0]*(M) for _ in range(N)]
    visited[r][c] = 1
    temp = 0
    while q:
        vr, vc = q.popleft()

        for dr, dc in [(0,1),(0,-1),(1,0),(-1,0),(1,1),(-1,-1),(1,-1),(-1,1)]:
            newR = dr+vr
            newC = dc+vc
            if 0<=newR<N and 0<=newC<M and not visited[newR][newC]:
                q.append((newR,newC))
                visited[newR][newC] = visited[vr][vc] + 1
                if lst[newR][newC]:
                    temp = visited[vr][vc]
                    if temp > max_V:
                        max_V = temp
                    return




N, M = map(int, input().split())
lst = [list(map(int, input().split())) for _ in range(N)]

cnt = 1
max_V = -10e9
for i in range(N):
    for j in range(M):
        if lst[i][j] != 1:
            bfs(i,j)
            cnt += 1
print(max_V)