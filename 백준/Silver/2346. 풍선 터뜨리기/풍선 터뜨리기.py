N = int(input())
lst = list(map(int, input().split()))
target = 0
index = [i for i in range(1, N+1)]
answer = []
temp = lst.pop(target)
answer.append(index.pop(target))
while lst:
    if temp < 0:
        target = (target+temp)%len(lst)
    else:
        target = (target+temp-1)%len(lst)
    temp = lst.pop(target)
    answer.append(index.pop(target))
print(*answer)