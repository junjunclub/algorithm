t = int(input())
for _ in range(t):
    S, E = map(int, input().split())

    gap = E-S

    temp = 0
    cnt = 0
    move = 0

    while temp < gap:
        cnt += 1
        if cnt % 2 != 0:
            move += 1
        temp += move
    print(cnt)