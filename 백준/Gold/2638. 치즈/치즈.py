from collections import deque

def bfs(r, c):
    global flag
    q = deque()
    q.append((r,c))
    visited = [[0] * M for _ in range(N)]
    visited[r][c] = 1
    while q:
        vr, vc = q.popleft()

        for dr, dc in [(0,1),(0,-1),(1,0),(-1,0)]:
            newR = dr+vr
            newC = dc+vc


            if 0<=newR<N and 0<=newC<M:
                if lst[newR][newC] == 1:
                    melting[newR][newC] += 1
                    flag = True
                if not visited[newR][newC] and lst[newR][newC] == 0:
                    q.append((newR,newC))
                    visited[newR][newC] = 1

N, M = map(int, input().split())
lst = [list(map(int, input().split())) for _ in range(N)]

flag = True
cnt = 0
while flag:
    flag = False
    cnt += 1
    melting = [[0] * M for _ in range(N)]
    bfs(0,0)

    for i in range(N):
        for j in range(M):
            if melting[i][j] >= 2:
                lst[i][j] = 0

print(cnt-1)