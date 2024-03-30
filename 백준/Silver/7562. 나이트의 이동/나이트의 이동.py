from collections import deque

def bfs(r, c):
    q = deque()
    q.append((r,c))
    lst[r][c] = 0

    while q:
        vr, vc = q.popleft()

        for dr, dc in [(2,1),(-2,1),(2,-1),(-2,-1),(1,-2),(-1,2),(1,2),(-1,-2)]:
            newR = dr+vr
            newC = dc+vc
            if 0<=newR<N and 0<=newC<N and lst[newR][newC] == -1:
                q.append((newR,newC))
                lst[newR][newC] = lst[vr][vc]+1



T = int(input())
for _ in range(T):
    N = int(input())
    lst = [[-1]*N for _ in range(N)]
    nr, nc = map(int, input().split())
    gr, gc = map(int, input().split())

    bfs(nr, nc)
    print(lst[gr][gc])