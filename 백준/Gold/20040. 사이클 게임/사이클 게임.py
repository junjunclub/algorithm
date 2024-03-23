import sys
input = sys.stdin.readline

def find(x):
    if p[x] != x:
        p[x] = find(p[x])
    return p[x]

def union(x, y):
    global answer
    x = find(x)
    y = find(y)

    if x == y:
        answer += 1
        return

    if x < y:
        p[y] = x
    else:
        p[x] = y

N, M = map(int, input().split())
p = [i for i in range(N)]
answer = 0
for j in range(M):
    a, b = map(int, input().split())
    union(a, b)
    if answer >= 1:
        print(j+1)
        break
else:
    print(answer)
