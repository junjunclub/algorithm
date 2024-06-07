N = int(input())

max_dp = [0]*3
min_dp = [0]*3

max_temp = [0]*3
min_temp = [0]*3

for j in range(N):
    a, b, c = map(int, input().split())
    for k in range(3):
        if k == 0:
            max_temp[0] = a + max(max_dp[0], max_dp[1])
            min_temp[0] = a + min(min_dp[0], min_dp[1])
        elif k == 1:
            max_temp[1] = b + max(max_dp[0], max_dp[1], max_dp[2])
            min_temp[1] = b + min(min_dp[0], min_dp[1], min_dp[2])
        else:
            max_temp[2] = c + max(max_dp[1], max_dp[2])
            min_temp[2] = c + min(min_dp[1], min_dp[2])

    max_dp = max_temp[:]
    min_dp = min_temp[:]
print(max(max_dp), min(min_dp))