T = int(input())
for _ in range(T):
    N = int(input())
    lst = []
    for _ in range(N):
        a, b = list(map(int, input().split()))
        lst.append([a,b])
    lst.sort()
    cnt = 1
    tmp = lst[0][1]
    for i in lst:
        if tmp > i[1]:
            tmp = i[1]
            cnt += 1
    print(cnt)