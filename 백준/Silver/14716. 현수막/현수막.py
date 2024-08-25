import sys
sys.setrecursionlimit(100000)

def dfs(r, c):
    visited[r][c] = 1

    for dr, dc in [(0,1),(0,-1),(1,0),(-1,0),(1,1),(-1,1),(1,-1),(-1,-1)]:
        newR = dr+r
        newC = dc+c
        if 0<=newR<N and 0<=newC<M and not visited[newR][newC] and lst[newR][newC]:
            dfs(newR, newC)

N, M = map(int, input().split())
lst = [list(map(int, input().split())) for _ in range(N)]
# print(lst)
visited = [[0]*M for _ in range(N)]
answer = 0
for i in range(N):
    for j in range(M):
        if not visited[i][j] and lst[i][j]:
            dfs(i, j)
            answer += 1
print(answer)