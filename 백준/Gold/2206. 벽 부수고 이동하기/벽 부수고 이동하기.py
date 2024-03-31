from collections import deque


def bfs():
    q = deque()
    q.append((0,0,0))
    visited[0][0][0] = 1

    while q:
        vr, vc, b_cnt = q.popleft()

        if vr == N-1 and vc == M-1:
            return visited[vr][vc][b_cnt]

        for dr, dc in [(0,1),(0,-1),(1,0),(-1,0)]:
            newR = dr+vr
            newC = dc+vc
            if 0<=newR<N and 0<=newC<M:
                #  벽 부수기 전 벽을 만나면
                if lst[newR][newC] == 1 and b_cnt == 0:
                    visited[newR][newC][1] = visited[vr][vc][b_cnt] + 1
                    q.append((newR,newC,1))
                # 벽이 아니고 방문하지 않았을 때
                elif lst[newR][newC] == 0 and visited[newR][newC][b_cnt] == 0:
                    visited[newR][newC][b_cnt] = visited[vr][vc][b_cnt] + 1
                    q.append((newR,newC,b_cnt))
    return -1



N, M = map(int, input().split())
lst = [list(map(int, input())) for _ in range(N)]
visited = [[[0]*2 for _ in range(M)] for _ in range(N)]

print(bfs())
