T = int(input())
dp = [0]*101
dp[1], dp[2], dp[3], dp[4], dp[5], dp[6] = 1, 1, 1, 2, 2, 3

for i in range(7, 101):
    dp[i] = dp[i-1]+dp[i-5]


for _ in range(T):
    num = int(input())
    print(dp[num])