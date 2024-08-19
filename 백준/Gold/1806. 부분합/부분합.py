import sys
input = sys.stdin.readline

N, S = map(int, input().split())
lst = list(map(int, input().split()))
L = len(lst)
sum_lst = [0]*(L+1)
sum_lst[0] = lst[0]
for i in range(1, L):
    sum_lst[i] = sum_lst[i-1] + lst[i]

s, e = 0, 0
answer = 0
while e < L:
    if s:
        if s == e:
            sumV = lst[s]
        else:
            sumV = sum_lst[e] - sum_lst[s-1]
    else:
        sumV = sum_lst[e]
    # S보다 작을 경우
    if sumV < S:
        e += 1
    # S보다 클 경우
    else:
        length = e - s + 1
        if answer == 0:
            answer = length
        elif length < answer:
            answer = length
        s += 1
print(answer)

