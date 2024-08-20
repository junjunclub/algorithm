import sys
input = sys.stdin.readline
N = int(input())
lst = list(map(int, input().split()))
answer = [0] * N
ST = []

for i in range(N):
    while ST:
        if ST[-1][1] > lst[i]:
            answer[i] = ST[-1][0] + 1
            break
        else:
            ST.pop()
    ST.append((i, lst[i]))
print(*answer)