N = int(input())
L = int(input())
st = input()

answer = 0
cnt = 0
idx = 0
while idx < L-1:
    if st[idx:idx+3] == 'IOI':
        cnt += 1
        idx += 2
        if cnt == N:
            answer += 1
            cnt -= 1
    else:
        idx += 1
        cnt = 0
print(answer)