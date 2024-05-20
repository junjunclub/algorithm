N, M = map(int, input().split())
lst = list(map(int, input().split()))
min_num = min(lst)
max_num = max(lst)

s = 0
e = max_num*M
result = s
while s <= e:
    m = (s+e)//2
    temp = 0
    for i in lst:
        temp += m // i

    # 필요한 풍선보다 많은 경우, 분을 줄임
    if temp >= M:
        e = m-1
        result = m
    else:
        s = m+1
print(result)
