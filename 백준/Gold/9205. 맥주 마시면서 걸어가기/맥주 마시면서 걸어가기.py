from collections import deque

def bfs():
    q = deque()
    q.append((home[0],home[1]))

    while q:
        vr, vc = q.popleft()
        if abs(rock[0]-vr)+abs(rock[1]-vc) <= 1000:
            print('happy')
            return
        for i in range(N):
            if not visited[i]:
                newR, newC = conv[i]
                if abs(newR-vr)+abs(newC-vc) <= 1000:
                    q.append((newR,newC))
                    visited[i] = 1
    print('sad')
    return


T = int(input())
for _ in range(T):
    N = int(input())
    conv = []
    visited = [0]*(N+1)
    home = list(map(int, input().split()))
    for _ in range(N):
        a, b = map(int, input().split())
        conv.append((a,b))
    rock = list(map(int, input().split()))
    bfs()