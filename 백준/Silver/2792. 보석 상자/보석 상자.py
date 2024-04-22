N, M = map(int, input().split())
lst = []
for _ in range(M):
    lst.append(int(input()))

start = 1
end = max(lst)
answer = 0
while start <= end:
    mid = (start+end)//2
    total = 0
    for i in lst:
        if i % mid == 0:
            total += i//mid
        else:
            total += (i//mid)+1
    if total > N:
        start = mid + 1
    else:
        end = mid - 1
        answer = mid
    #print(mid)
print(answer)

