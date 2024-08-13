import sys
input = sys.stdin.readline

N = int(input())
ST = []
for _ in range(N):
    num = list(map(int, input().split()))
    if len(num) == 2:
        ST.append(num[1])
    else:
        if num[0] == 2:
            if ST:
                print(ST.pop())
            else:
                print(-1)
        elif num[0] == 3:
            print(len(ST))
        elif num[0] == 4:
            if ST:
                print(0)
            else:
                print(1)
        elif num[0] == 5:
            if ST:
                print(ST[-1])
            else:
                print(-1)