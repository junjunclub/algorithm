def dfs(r, c):
    global flag
    visited[r][c] = 1

    for dr, dc in [(0, 1), (0, -1), (1, 0), (-1, 0), (1, 1), (1, -1), (-1, 1), (-1, -1)]:
        newR = dr + r
        newC = dc + c

        if 0 <= newR < N and 0 <= newC < M:
            if lst[newR][newC] > lst[r][c]:
                flag = 0
            if not visited[newR][newC] and lst[newR][newC] == lst[r][c]:
                dfs(newR, newC)


N, M = map(int, input().split())
lst = [list(map(int, input().split())) for _ in range(N)]

visited = [[0] * M for _ in range(N)]
cnt = 0
for i in range(N):
    for j in range(M):
        if not visited[i][j] and lst[i][j] > 0:
            flag = 1
            dfs(i, j)
            if flag:
                cnt += 1

print(cnt)
