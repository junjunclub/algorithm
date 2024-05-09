S, C = map(int, input().split())
lst = []
for _ in range(S):
    L = int(input())
    lst.append(L)

s = 1
e = max(lst)

while s <= e:
    temp = 0
    mid = (s+e) // 2
    for i in range(S):
        temp += lst[i] // mid

    # 만약 만들어야 하는 치킨보다 덜 들어갈 경우?
    # 파를 더 짧게 썰어야함
    if temp < C:
        e = mid-1
    # 만들어야 하는 치킨보다 같거나 더 많은 경우?
    # 좀 더 썰어도 됨
    else:
        s = mid+1

print(sum(lst)-C*e)