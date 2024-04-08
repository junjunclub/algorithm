from collections import deque

def bfs(col, row, value, visit, lst):
    q = deque()
    q.append((col, row))
    visit[col][row] = True

    while q:
        y, x = q.popleft()

        for dy, dx in ((1, 0), (-1, 0), (0, 1), (0, -1)):
            ny = y + dy
            nx = x + dx
            if 0 <= ny <= N - 1 and 0 <= nx <= N - 1 and lst[ny][nx] in value and not visit[ny][nx]:
                q.append((ny, nx))
                visit[ny][nx] = True


N = int(input()) # 적록색약이 아닌 사람이 봤을 때 구역 개수 , 적록색약인 사람이 봤을 때 구역 개수

lst = [list(input()) for _ in range(N)]

b_cnt = 0
cnt = 0
visited = [[False]*N for _ in range(N)]
visited2 = [[False]*N for _ in range(N)]
for y in range(N):
    for x in range(N):
        if not visited[y][x]:
            if lst[y][x] == 'R' or lst[y][x] == 'G':
                bfs(y, x, ['R', 'G'], visited, lst)

            elif lst[y][x] == 'B':
                bfs(y, x, ['B'], visited, lst)
            b_cnt += 1

        if not visited2[y][x]:
            if lst[y][x] != 0:
                bfs(y, x, lst[y][x], visited2, lst)
                cnt += 1

print(cnt, b_cnt)