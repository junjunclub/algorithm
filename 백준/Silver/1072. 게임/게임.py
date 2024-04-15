X, Y = map(int, input().split())
Z = Y*100//X
s = 0
e = X
answer = 0
if Z >= 99:
    print(-1)
else:
    while s <= e:
        m = (s+e)//2
        if (Y+m)*100//(X+m) > Z:
            answer = m
            e = m-1
        else:
            s = m+1

    print(answer)