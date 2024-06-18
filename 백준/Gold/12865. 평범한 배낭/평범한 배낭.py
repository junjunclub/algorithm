N, K = map(int, input().split())
lst = [[0,0]]
for _ in range(N):
    lst.append(list(map(int, input().split())))
# print(lst)

dp = [[0]*(K+1) for _ in range(N+1)]

for i in range(1, N+1):
    for j in range(1, K+1):
        weight = lst[i][0]
        value = lst[i][1]
        # 무게 초과 시
        if j < weight:
            dp[i][j] = dp[i-1][j]
        else:
            dp[i][j] = max(dp[i-1][j], dp[i-1][j-weight]+value)
print(dp[N][K])
