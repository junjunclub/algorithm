from collections import deque

def bfs(r, c):
    Q = deque()
    Q.append((r,c))
    visited[r][c] = 0

    while Q:
        vr, vc = Q.popleft()

        for dr, dc in [(1,0),(-1,0),(0,-1),(0,1)]:
            newR = dr+vr
            newC = vc+dc

            if 0<=newR<n and 0<=newC<m and not visited[newR][newC] and lst[newR][newC] == 1:
                Q.append((newR,newC))
                visited[newR][newC] = visited[vr][vc]+1

n, m = map(int, input().split())
lst = [list(map(int, input().split())) for _ in range(n)]
visited = [[0]*m for _ in range(n)]

sr = sc = 0
for i in range(n):
    for j in range(m):
        if lst[i][j] == 2:
            sr, sc = i, j
            bfs(i,j)

for a in range(n):
    for b in range(m):
        if not visited[a][b] and lst[a][b]:
            visited[a][b] = -1
visited[sr][sc] = 0

for row in visited:
    print(*row)
