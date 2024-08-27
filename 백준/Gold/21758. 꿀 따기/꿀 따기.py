N = int(input())
lst = list(map(int, input().split()))
# print(lst)
answer = 0
sum_lst = []
sum_lst.append(lst[0])
for i in range(1, N):
    sum_lst.append(lst[i]+sum_lst[i-1])
# print(sum_lst)

# 통벌벌
for i in range(1, N-1):
    answer = max(answer, sum_lst[N-2]-lst[i]+sum_lst[i-1])

# 벌통벌
for i in range(1, N-1):
    answer = max(answer, sum_lst[i]-lst[0] + lst[i])

# 벌벌통
for i in range(1, N-1):
    answer = max(answer, 2*sum_lst[N-1] - lst[0] - lst[i] - sum_lst[i])

print(answer)