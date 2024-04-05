import sys
input = sys.stdin.readline
# 시간초과 한 코드
# def dfs(r, c, value):
#     global answer
#     if r == N-1 and c == N-1:
#         answer += 1
#         return
#
#     for dr, dc in [(0,1),(0,-1),(1,0),(-1,0)]:
#         newR = dr+r
#         newC = dc+c
#         if 0<=newR<N and 0<=newC<M and not visited[newR][newC] and lst[newR][newC] < value:
#             visited[newR][newC] = 1
#             dfs(newR, newC, lst[newR][newC])
#             visited[newR][newC] = 0
#
#
# N, M = map(int, input().split())
# lst = [list(map(int, input().split())) for _ in range(N)]
# visited = [[0]*M for _ in range(N)]
# answer = 0
# dfs(0,0,lst[0][0])
# print(answer)

# DFS + DP 꼭 다시 풀어보기....
def dfs(r, c):
    if r == N-1 and c == M-1:
        return 1

    if dp[r][c] == -1:
        dp[r][c] = 0

        for dr, dc in [(0,1),(0,-1),(1,0),(-1,0)]:
            newR = dr+r
            newC = dc+c
            if 0<=newR<N and 0<=newC<M and lst[newR][newC] < lst[r][c]:
                dp[r][c] += dfs(newR,newC)

    return dp[r][c]


N, M = map(int, input().split())
lst = [list(map(int, input().split())) for _ in range(N)]
dp = [[-1]*M for _ in range(N)]

print(dfs(0,0))