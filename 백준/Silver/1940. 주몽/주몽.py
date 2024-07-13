N = int(input())
M = int(input())
lst = list(map(int, input().split()))
lst.sort()
p1 = 0
p2 = N-1
answer = 0
while p1 < p2:
    if lst[p1]+lst[p2] < M:
        p1 += 1
    elif lst[p1]+lst[p2] > M:
        p2 -= 1
    else:
        p1 += 1
        p2 -= 1
        answer += 1
print(answer)