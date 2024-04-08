from collections import deque
import sys

def bfs(pos):
    q = deque()
    visited = [[[False] * M for _ in range(N)] for _ in range(H)]
    for height, sero, garo in pos:
        q.append((height, sero, garo, 0))
        visited[height][sero][garo] = True

    while q:
        h, y, x, cnt = q.popleft()
        for dh, dy, dx in ((0, 1, 0), (0, 0, 1), (0, -1, 0), (0, 0, -1), (-1, 0, 0), (1, 0, 0)):
            nh = h + dh
            ny = y + dy
            nx = x + dx
            if 0 <= nh < H and 0 <= ny < N and 0 <= nx < M:
                if not visited[nh][ny][nx] and tomato[nh][ny][nx] == 0:
                    tomato[nh][ny][nx] = 1
                    visited[nh][ny][nx] = True
                    q.append((nh, ny, nx, cnt + 1))
    else:
        unripe_tomato_exists = any(tomato[h][n][m] == 0 for h in range(H) for n in range(N) for m in range(M))
        if unripe_tomato_exists:
            return -1
        else:
            return cnt


M, N, H = map(int, sys.stdin.readline().split()) # M 가로, N 세로, H 상자 수
tomato = [[list(map(int, sys.stdin.readline().split())) for _ in range(N)] for _ in range(H)]
position = []
cnt = 0
for n in range(N):
    for m in range(M):
        for h in range(H):
            if tomato[h][n][m] == 1:
                position.append((h, n, m))
answer = bfs(position)
print(answer)