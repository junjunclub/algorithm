def w_check(arr):
    cnt = 0
    for i in range(8):
        for j in range(8):
            if i+j%2 == 0 and arr[i][j] == 'B': # i+j가 짝수인 칸에서, i,j가 B면 바꿔줘야할 횟수 +1
                cnt += 1
            elif i+j%2 == 1 and arr[i][j] == 'W':
                cnt += 1
    return cnt

def b_check(arr):
    cnt = 0
    for i in range(8):
        for j in range(8):
            if i+j%2 == 0 and arr[i][j] == 'W': # i+j가 짝수인 칸에서, i,j가 B면 바꿔줘야할 횟수 +1
                cnt += 1
            elif i+j%2 == 1 and arr[i][j] == 'B':
                cnt += 1
    return cnt

N, M = map(int, input().split())
lst = [list(input()) for _ in range(N)]
min_V = N*M
for row in range(M-8+1):
    for col in range(N-8+1):
        cnt_B = 0
        for i in range(col, col+8):
            for j in range(row, row+8):
                if (i+j) % 2 == 0 and lst[i][j] == 'B':  # i+j가 짝수인 칸에서, i,j가 B면 바꿔줘야할 횟수 +1
                    cnt_B += 1
                elif (i+j) % 2 == 1 and lst[i][j] == 'W':
                    cnt_B += 1
        if min_V > cnt_B:
            min_V = cnt_B
        cnt_W = 0
        for i in range(col, col+8):
            for j in range(row, row+8):
                if (i + j) % 2 == 0 and lst[i][j] == 'W':  # i+j가 짝수인 칸에서, i,j가 B면 바꿔줘야할 횟수 +1
                    cnt_W += 1
                elif (i + j) % 2 == 1 and lst[i][j] == 'B':
                    cnt_W += 1
        if min_V > cnt_W:
            min_V = cnt_W
print(min_V)