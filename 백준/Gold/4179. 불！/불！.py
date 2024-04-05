from collections import deque

def bfs():
    global is_end
    while fire:
        vr, vc, flag = fire.popleft()

        for dr, dc in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
            newR = dr + vr
            newC = dc + vc
            if 0 <= newR < N and 0 <= newC < M and not visited[newR][newC] and lst[newR][newC] != '#':
                if flag == 1:
                    fire.append((newR, newC, flag))
                    visited[newR][newC] = visited[vr][vc] + 1
                elif flag == 0:
                    fire.append((newR, newC, flag))
                    visited[newR][newC] = visited[vr][vc] - 1
                if ((newR == N - 1 or newR == 0) and visited[newR][newC] >= 0) or ((newC == 0 or newC == M - 1) and visited[newR][newC] >= 0):
                    print(visited[newR][newC])
                    return
    # print(visited)
    print('IMPOSSIBLE')

N, M = map(int, input().split())
lst = [list(input()) for _ in range(N)]
visited = [[0]*M for _ in range(N)]
is_end = False
fire = deque()
jx = 0
jy = 0
for i in range(N):
    for j in range(M):
        if lst[i][j] == 'F':
            fire.appendleft((i,j,0))
            visited[i][j] = -1
        elif lst[i][j] == 'J':
            fire.append((i,j,1))
            visited[i][j] = 1
            jx = i
            jy = j
if jx == 0 or jx == N-1 or jy == 0 or jy == M-1:
    print(1)
else:
    bfs()