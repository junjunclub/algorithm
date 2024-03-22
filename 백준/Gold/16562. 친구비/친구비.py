import sys
input = sys.stdin.readline

def find(x):
    if p[x] != x:
        p[x] = find(p[x])
    return p[x]

def union(x, y):
    x = find(x)
    y = find(y)

    if x == y:
        return

    if lst[x] < lst[y]:
        p[y] = x
    else:
        p[x] = y

N, M, k = map(int, input().split())
p = [i for i in range(N+1)]
lst = [0]+list(map(int, input().split()))
for _ in range(M):
    a, b = map(int, input().split())
    union(a, b)
# print(p)
p_lst = []
money = 0
for i in p:
    p_friend = find(i)
    if p_friend not in p_lst:
        money += lst[p_friend]
        p_lst.append(p_friend)
# print(money)

if money <= k:
    print(money)
else:
    print('Oh no')