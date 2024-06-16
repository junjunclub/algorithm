def recur(r,c,n):
    global minus,zero,plus
    value = lst[r][c]

    for i in range(r,r+n):
        for j in range(c,c+n):
            if lst[i][j] != value:
                new_n = n//3
                for k in range(3):
                    for p in range(3):
                        recur(r+k*new_n,c+p*new_n,new_n)
                return
    # print(value)
    if value == -1:
        minus += 1
    elif value == 0:
        zero += 1
    elif value == 1:
        plus += 1


N = int(input())
lst = [list(map(int, input().split())) for _ in range(N)]
minus, zero, plus = 0,0,0
recur(0,0,N)
print(minus)
print(zero)
print(plus)