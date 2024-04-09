def apart_solve(k, n):
    apart = [[0] * 15 for _ in range(15)]
    for i in range(0, 15):
        for j in range(1, 15):
            if i == 0:
                apart[i][j] = j
            else:
                apart[i][j] = apart[i][j - 1] + apart[i - 1][j]

            if i == k and j == n:
                return apart[i][j]

T = int(input())
for _ in range(T):
    k = int(input())
    n = int(input())
    print(apart_solve(k, n))