T = int(input())
dp = [0]*1000001
dp[1], dp[2], dp[3], dp[4] = 1, 2, 4, 7
for i in range(5, 1000001):
    dp[i] = (dp[i-3]+dp[i-2]+dp[i-1])%1000000009
for _ in range(T):
    num = int(input())
    print(dp[num])