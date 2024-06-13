import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)

def dfs(r, c):
    if DP[r][c]:
        return DP[r][c]

    DP[r][c] = 1

    for dr, dc in [(0,1),(0,-1),(1,0),(-1,0)]:
        newR = dr+r
        newC = dc+c
        if 0<=newR<N and 0<=newC<N and lst[r][c] < lst[newR][newC]:
            DP[r][c] = max(DP[r][c], dfs(newR,newC)+1)
    return DP[r][c]

N = int(input())
lst = [list(map(int, input().split())) for _ in range(N)]
DP = [[0]*N for _ in range(N)]
answer = 0
for i in range(N):
    for j in range(N):
        if not DP[i][j]:
            answer = max(answer, dfs(i,j))
print(answer)