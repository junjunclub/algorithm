N, X = map(int, input().split())
lst = list(map(int, input().split()))

if max(lst) == 0:
    print('SAD')
else:
    s_value = sum(lst[:X])
    max_V = s_value
    cnt = 1
    for i in range(X, N):
        s_value -= lst[i-X]
        s_value += lst[i]

        if s_value > max_V:
            max_V = s_value
            cnt = 1
        elif s_value == max_V:
            cnt += 1
    print(max_V)
    print(cnt)