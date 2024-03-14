# 시간 초과
# N, K = map(int, input().split())
# lst = list(map(int, input().split()))

# max_V = 0 # 최댓값을 넣을 변수
# for i in range(N-K+1): # 0부터 N-K+1만큼 반복
#     if max_V < sum(lst[i:i+K]): # max_V가 lst[i]부터 lst[i+K-1]의 합보다 작으면
#         max_V = sum(lst[i:i+K]) # max_V값 갱신
# print(max_V)

N, K = map(int, input().split())
lst = list(map(int, input().split()))

part_sum = sum(lst[:K])
answer = part_sum # part_sum 값을 answer에 저장

max_V = 0 # 최댓값을 넣을 변수
for i in range(N-K): # 0부터 N-K+1만큼 반복
    part_sum += lst[i+K]-lst[i] # part_sum 값에 lst의 i번째 값을 빼고, i+K번째 값을 더해준다.
    if answer < part_sum: # 그 값이 더 크면 answer 값 갱신
        answer = part_sum
    
print(answer)
