N = int(input())
lst = list(map(int, input().split()))
M = int(input())
lst.sort()
left = 0
right = lst[-1]

result = 0
while left <= right:
    tmp = 0
    m = (left+right)//2
    for i in lst:
        if i < m:
            tmp += i
        else:
            tmp += m
        if tmp > M:
            break


    if tmp > M:
        right = m-1
    else:
        left = m+1
        result = m
print(result)