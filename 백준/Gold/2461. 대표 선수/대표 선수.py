# -*- coding: utf-8 -*-
N, M = map(int, input().split())
lst = []
for _ in range(N):
    l = list(map(int, input().split()))
    l.sort()
    lst.append(l)
idx_lst = [0]*N

# 몇번 째 인덱스를 늘려줄것인지
idx_controller = -1

answer = 10e9

flag = True
# 최솟값의 인덱스를 하나씩 늘려준다.
while flag:
    min_v = 10e9
    max_v = 0
    for i in range(N):
        temp = lst[i][idx_lst[i]]
        if temp < min_v:
            min_v = temp
            idx_controller = i
        if temp > max_v:
            max_v = temp
    if max_v - min_v < answer:
        answer = max_v-min_v
    idx_lst[idx_controller] += 1
    if idx_lst[idx_controller] >= M:
        flag = False
print(answer)
