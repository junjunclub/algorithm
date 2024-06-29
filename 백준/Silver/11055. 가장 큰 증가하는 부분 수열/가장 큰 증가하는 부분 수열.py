N = int(input())
lst = list(map(int, input().split()))
dp = [lst[0]]+[0]*N

for i in range(1, N):
    for j in range(i):
        if lst[i] > lst[j]:
            dp[i] = max(dp[i], dp[j]+lst[i])
        else:
            dp[i] = max(dp[i],lst[i])
print(max(dp))