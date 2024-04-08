from collections import deque

def bfs(col, row):
    q = deque()
    q.append((col, row))
    lst[col][row] = 0
    while q:
        y, x = q.popleft()
        for dy, dx in ((0, 1), (1, 0), (-1, 0), (0, -1)):
            ny = y + dy
            nx = x + dx
            if 0 <= ny <= N-1 and 0 <= nx <= M-1 and lst[ny][nx] == 1:
                q.append((ny, nx))
                lst[ny][nx] = 0


T = int(input())

for _ in range(T):
    M, N, K = map(int, input().split()) # 가로길이 M, 세로길이 N, 배추 위치 개수 K
    lst = [[0]*M for _ in range(N)]
    for _ in range(K):
        x, y = map(int, input().split())
        lst[y][x] = 1

    cnt = 0
    for i in range(N):
        for j in range(M):
            if lst[i][j] == 1:
                bfs(i, j)
                cnt += 1
    print(cnt)