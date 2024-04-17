N, M = map(int, input().split())
lst = []
for _ in range(N):
    lst.append(int(input()))

left = min(lst)
right = sum(lst)

while left <= right:
    mid = (left+right) // 2
    day = 1
    money = mid
    for i in range(N):
        if money < lst[i]:
            day += 1
            money = mid
        money -= lst[i]
    if day > M or max(lst) > mid:
        left = mid + 1
    else:
        right = mid - 1
        answer = mid
print(answer)