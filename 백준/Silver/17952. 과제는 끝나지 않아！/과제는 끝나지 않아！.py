from collections import deque

N = int(input())
answer = 0
lst = deque()
for _ in range(N):
    arr = list(map(int, input().split()))
    if arr[0]:
        lst.appendleft([arr[1], arr[2]])

    if lst:
        lst[0][1] -= 1
        if lst[0][1] == 0:
            temp = lst.popleft()
            answer += temp[0]
    else:
        continue

print(answer)
