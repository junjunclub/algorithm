import sys
from collections import deque

input = sys.stdin.readline

def bfs(start):
    q = deque()
    q.append(start)
    lst[start] = 0

    while q:
        v = q.popleft()
        if v == K:
            break

        for d in [v*2,v-1,v+1]:
            newV = d
            if 0<=newV<100001 and lst[newV] == -1:
                if newV == v*2:
                    lst[newV] = lst[v]
                    q.appendleft(newV)
                else:
                    lst[newV] = lst[v]+1
                    q.append(newV)



N, K = map(int, input().split())
lst = [-1]*100001
bfs(N)
print(lst[K])