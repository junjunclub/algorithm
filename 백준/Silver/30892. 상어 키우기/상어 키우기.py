# def binary_search(s, e, big):
#     global size
#     result = -1
#     mid = 0
#     while s <= e:
#         mid = (s+e) // 2
#
#         if lst[mid] < big:
#             s = mid + 1
#             result = max(result, lst[mid])
#         else:
#             e = mid - 1
#     if lst:
#         lst.pop(mid)
#         return result
#     else:
#         result = -1
#         return result
#
# N, K, T = map(int, input().split())
# lst = list(map(int, input().split()))
#
# lst.sort()
#
# start = 0
# end = len(lst)-1
#
# size = T
# for i in range(K):
#     temp = binary_search(start, end, size)
#     if temp < 0:
#         break
#     else:
#         size += temp
#         end -= 1
# print(size)

N, K, T = map(int, input().split())
lst = list(map(int, input().split()))

can_eat = []
cant_eat = []

# 내림차순으로 정렬
lst.sort(reverse=True)

size = T
cnt = 0
while True:
    # print(lst)
    # 내가 먹을 수 없는 상어가 나올때까지 can_eat 리스트에 담는다
    if lst and lst[-1] < size:
        can_eat.append(lst.pop())
    # 먹을 수 없는 상어가 나왔다!
    else:
        # 먹을 수 있는 상어들이 리스트에 담겼을 때
        if can_eat:
            # 제일 마지막에 들어온 상어를 먹고 없애준다
            size += can_eat.pop()
            cnt += 1
            if cnt == K:
                break
        # 먹을 수 있는 상어가 없다면
        else:
            break
print(size)