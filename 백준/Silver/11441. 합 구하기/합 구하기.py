N = int(input())
lst = list(map(int, input().split()))
sum_lst = [0]
temp = 0
for i in range(N):
    temp += lst[i]
    sum_lst.append(temp)
# print(sum_lst)
M = int(input())
for _ in range(M):
    s, e = map(int, input().split())
    print(sum_lst[e]-sum_lst[s-1])