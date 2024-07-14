H, W = map(int, input().split())
lst = list(map(int, input().split()))

answer = 0
for i in range(1, W-1):
    left = max(lst[:i])
    right = max(lst[i+1:])

    min_wall = min(left, right)

    if lst[i] < min_wall:
        answer += min_wall - lst[i]
print(answer)