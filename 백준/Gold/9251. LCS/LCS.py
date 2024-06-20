st1 = input()
st2 = input()
l1 = len(st1)
l2 = len(st2)

dp = [[0]*(l2+1) for _ in range(l1+1)]

for i in range(1,l1+1):
    for j in range(1,l2+1):
        if st1[i-1] == st2[j-1]:
            dp[i][j] = dp[i-1][j-1] + 1
        else:
            dp[i][j] = max(dp[i][j-1], dp[i-1][j])
print(dp[-1][-1])