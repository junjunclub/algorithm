N = int(input())
lst = list(map(int, input().split()))
sum_lst = []
temp = 0
for i in range(N):
    temp += lst[i]
    sum_lst.append(temp)
# print(sum_lst)
M = int(input())
for _ in range(M):
    s, e = map(int, input().split())
    if s == 1:
        print(sum_lst[e-1])
    else:
        print(sum_lst[e-1]-sum_lst[s-2])