T = int(input())
for _ in range(T):
    n = int(input())
    lst = [list(map(int, input().split())) for _ in range(2)]
    dp = [[0]*n for _ in range(2)]
    dp[0][0], dp[1][0] = lst[0][0], lst[1][0]
    if n == 1:
        print(max(lst[0][0],lst[1][0]))
        continue
    else:
        for j in range(1, n):
            if j >= 2:
                dp[0][j] = max(dp[1][j-1], dp[1][j-2]) + lst[0][j]
                dp[1][j] = max(dp[0][j-1], dp[0][j-2]) + lst[1][j]
            else:
                dp[0][j] = lst[1][j-1] + lst[0][j]
                dp[1][j] = lst[0][j-1] + lst[1][j]
    print(max(dp[0][n-1],dp[1][n-1]))