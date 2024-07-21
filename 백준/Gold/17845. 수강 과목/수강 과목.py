N, K = map(int, input().split())
lst = [[0,0]]
for _ in range(K):
    lst.append(list(map(int, input().split())))

dp = [[0]*(N+1) for _ in range(K+1)]
for i in range(1, K+1):
    for j in range(1, N+1):
        value = lst[i][0]
        weight = lst[i][1]
        if j < weight:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-weight]+value)
print(dp[K][N])