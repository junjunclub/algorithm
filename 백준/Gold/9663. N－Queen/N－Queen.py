def dfs(n):
    global answer

    if n == N:
        answer += 1
        return

    for j in range(N):
        if v1[j] == v2[n+j] == v3[n-j] == 0:
            v1[j], v2[n+j], v3[n-j] = 1,1,1
            dfs(n+1)
            v1[j], v2[n+j], v3[n-j] = 0,0,0

N = int(input())

answer = 0

# 열
v1 = [0]*N
# 우하대각선
v2 = [0]*(2*N-1)
# 우상대각선
v3 = [0]*(2*N-1)

dfs(0)
print(answer)