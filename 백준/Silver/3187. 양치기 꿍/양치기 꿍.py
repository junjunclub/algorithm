from collections import deque

r, c = map(int, input().split())
arr = [list(input()) for _ in range(r)]
visited = [[False] * c for _ in range(r)]
d = [(-1, 0), (0, -1), (1, 0), (0, 1)] # ↑ ← ↓ →
v, k = 0, 0 # v: 늑대, k: 양

def bfs(a, b):
    global r, c, d, v, k
    sheep, wolf = 0, 0

    queue = deque([(a, b)])
    visited[a][b] = True
    if arr[a][b] == 'v': wolf += 1 # 늑대
    if arr[a][b] == 'k': sheep += 1 # 양

    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx, ny = x + d[i][0], y + d[i][1]
            if nx in range(r) and ny in range(c) and \
                arr[nx][ny] != '#' and not visited[nx][ny]:
                visited[nx][ny] = True
                if arr[nx][ny] == 'v': wolf += 1 # 늑대
                if arr[nx][ny] == 'k': sheep += 1 # 양
                queue.append((nx, ny))
    if wolf >= sheep: v += wolf
    else: k += sheep

def solution():
    global r, c, arr

    for x in range(r):
        for y in range(c):
            if arr[x][y] != '#' and not visited[x][y]:
                bfs(x, y)

    print(k, v)

solution()