N, M = map(int, input().split())
lst = list(map(int, input().split()))
start, end = 1, max(lst)
while start <= end:
    mid = (start+end)//2

    tree = 0
    for i in lst:
        if i > mid:
            tree += i-mid

    if tree < M:
        end = mid-1
    else:
        start = mid+1
print(end)