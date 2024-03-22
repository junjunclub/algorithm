import sys
input = sys.stdin.readline

def find(x):
    if p[x] != x:
        p[x] = find(p[x])
    return p[x]

def union(x, y):
    x = find(x)
    y = find(y)

    if x < y:
        p[y] = x
    else:
        p[x] = y

T = int(input())
N = int(input())
p = [i for i in range(T+1)]
for j in range(T):
    lst = list(map(int, input().split()))
    for k in range(len(lst)):
        if lst[k] == 1:
            union(j+1, k+1)

visited = list(map(int, input().split()))
value = find(visited[0])
for city in range(len(visited)):
    if find(visited[city]) != value:
        print('NO')
        break
else:
    print('YES')
