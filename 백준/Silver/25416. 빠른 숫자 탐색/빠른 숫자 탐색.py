from collections import deque

def bfs(r, c):
    global answer
    q = deque()
    q.append((r, c))
    visited = [[0]*5 for _ in range(5)]
    visited[r][c] = 1
    while q:
        vr, vc = q.popleft()

        if lst[vr][vc] == 1:
            answer = visited[vr][vc]
            return


        for dr, dc in [(0,1),(0,-1),(1,0),(-1,0)]:
            newR = vr+dr
            newC = vc+dc
            if 0<=newR<5 and 0<=newC<5 and not visited[newR][newC] and lst[newR][newC] != -1:
                q.append((newR,newC))
                visited[newR][newC] = visited[vr][vc] + 1


lst = [list(map(int, input().split())) for _ in range(5)]
R, C = map(int, input().split())
answer = -1
bfs(R, C)
if answer != -1:
    print(answer - 1)
else:
    print(answer)