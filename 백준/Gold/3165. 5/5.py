N, K = map(int, input().split())


# 시간초과 풀이법
# cnt = 0
# flag = False
# while N % 5 != 0 or flag == False:
#     N += 1
#     flag = True
#
# while cnt != K:
#     cnt = 0
#     N += 5
#     st = str(N)
#     for i in st:
#         if i == '5':
#             cnt += 1
# print(N)

# 백트래킹을 이용한 풀이
N += 1
lst = list(str(N))
chk_idx = -1

length = len(lst)
while True:
    if lst.count('5') >= K:
        break

    if lst[chk_idx] == '5' and length > abs(chk_idx):
        chk_idx -= 1

    value = int(''.join(lst))
    value += 10**(abs(chk_idx)-1)
    lst = list(str(value))
    length = len(lst)
print(''.join(lst))