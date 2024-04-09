from collections import deque

def bfs(y1, x1, y2, x2):
    q = deque()
    q.append((y1, x1, 0))
    lst[y1][x1] += 1
    while q:
        y, x, cnt = q.popleft()
        if y == y2 and x == x2:
            return cnt
        for dy, dx in ((1, -2), (2, -1), (2, 1), (1, 2), (-1, 2), (-2, 1), (-1, -2), (-2, -1)):
            ny = y + dy
            nx = x + dx
            if 0 <= ny <= I-1 and 0 <= nx <= I-1 and lst[ny][nx] == 0:
                q.append((ny, nx, cnt+1))
                lst[ny][nx] = cnt
    else:
        return 0

T = int(input()) # 테스트 케이스 개수

for _ in range(T):
    I = int(input()) # 한 변의 길이
    lst = [[0] * I for _ in range(I)]
    x1, y1 = map(int, input().split())
    x2, y2 = map(int, input().split())
    answer = bfs(y1, x1, y2, x2)
    print(answer)