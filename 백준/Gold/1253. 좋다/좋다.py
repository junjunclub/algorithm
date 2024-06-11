N = int(input())
lst = list(map(int, input().split()))
lst.sort()
answer = 0
for i in range(N):
    value = lst[i]
    s = 0
    e = len(lst)-1
    while s < e:
        if lst[s]+lst[e] == value:
            if s == i:
                s += 1
            elif e == i:
                e -= 1
            else:
                answer += 1
                break
        elif lst[s]+lst[e] < value:
            s += 1
        elif lst[s]+lst[e] > value:
            e -= 1
print(answer)