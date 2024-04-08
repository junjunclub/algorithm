from collections import deque

def bfs(r, c):
    global min_V, sr, sc, answer
    q = deque()
    q.append((r,c))
    visited = [[-1]*N for _ in range(N)]
    visited[r][c] = 0
    lst[r][c] = 0


    tmplst = []


    isFirstSize = -1
    while q:
        vr, vc = q.popleft()
        if isFirstSize != -1 and visited[vr][vc] == isFirstSize and 0<lst[vr][vc]<size:
            tmplst.append((vr,vc))
        #     if tmplst:
        #         tmplst.sort()
        #
        #         sr = tmplst[0][0]
        #         sc = tmplst[0][1]
        #         min_V = isFirstSize
        #         # print(tmplst)
        #         return True
        #     else:
        #         return False
        # elif visited[vr][vc] == isFirstSize and lst[vr][vc] < size:
        #     tmplst.append((vr,vc))

        for dr, dc in d:
            newR = dr+vr
            newC = dc+vc
            if 0<=newR<N and 0<=newC<N and visited[newR][newC] == -1:
                if lst[newR][newC] <= size:
                    visited[newR][newC] = visited[vr][vc] + 1
                    q.append((newR,newC))
                if 0 < lst[newR][newC] < size and visited[newR][newC] != -1:
                    if isFirstSize == -1:
                        isFirstSize = visited[newR][newC]
    if tmplst:
        tmplst.sort()
        sr = tmplst[0][0]
        sc = tmplst[0][1]
        min_V = isFirstSize
        return True
    else:
        return False
    # 불필요한 반복문 제거
    # for r in range(N):
    #     for c in range(N):
    #         if visited[r][c] != -1 and 0< lst[r][c] < size:
    #             if visited[r][c] < min_V:
    #                 min_V = visited[r][c]
    #                 # print(lst)
    #                 # print(visited)
    #                 sr = r
    #                 sc = c
    #             return min_V



d = [(-1, 0), (0, -1), (0, 1), (1, 0)]
N = int(input())
lst = [list(map(int, input().split())) for _ in range(N)]
sr = 0
sc = 0
# 상어의 초기 사이즈
size = 2
eat_fish = 0
answer = 0
# 상어의 위치를 구하고 있던 자리를 0으로 바꿔준다.
for i in range(N):
    for j in range(N):
        if lst[i][j] == 9:
            sr = i
            sc = j
tmp = []
dist = []
while True:
    min_V = 10e9
    # 상어 위치에서 bfs
    if bfs(sr, sc):
        answer += min_V
        eat_fish += 1
        if eat_fish == size:
            size += 1
            size = min(size, 7)
            eat_fish = 0
    else:
        break
print(answer)