from collections import deque

def bfs(r, c):
    global min_V, sr, sc, answer
    q = deque()
    q.append((r,c))
    visited = [[-1]*N for _ in range(N)]
    # 방문처리
    visited[r][c] = 0
    # 상어의 위치에는 물고기가 없다.
    lst[r][c] = 0
    
    # 최소거리의 좌표를 담을 배열
    tmplst = []

    # 가까운 거리를 저장할 변수
    isFirstSize = -1
    while q:
        vr, vc = q.popleft()
        
        # 가까운거리를 찾은 이후, visited배열이 최소임을 만족하고, 먹을 수 있는 물고기가 있는 좌표를 tmplst에 담아준다.
        if isFirstSize != -1 and visited[vr][vc] == isFirstSize and 0<lst[vr][vc]<size:
            tmplst.append((vr,vc))
        
        # 일반적인 bfs
        for dr, dc in d:
            newR = dr+vr
            newC = dc+vc
            if 0<=newR<N and 0<=newC<N and visited[newR][newC] == -1:
                # 상어와 사이즈가 같은 물고기 칸은 지나갈 수 있음
                if lst[newR][newC] <= size:
                    visited[newR][newC] = visited[vr][vc] + 1
                    q.append((newR,newC))
                # 먹을 수 있는 물고기가 최초로 나타나는 순간 그 거리를 저장한다.
                if 0 < lst[newR][newC] < size and visited[newR][newC] != -1:
                    if isFirstSize == -1:
                        isFirstSize = visited[newR][newC]
                        
    # 만약 tmplst가 있다면 정렬하고, 상어위치 갱신, 그리고 거리를 갱신해준다.
    if tmplst:
        tmplst.sort()
        sr = tmplst[0][0]
        sc = tmplst[0][1]
        min_V = isFirstSize
        return True
    # tmplst가 없는 경우는 갇힌경우, 먹을게 없는 경우 이다.
    else:
        return False

d = [(-1, 0), (0, -1), (0, 1), (1, 0)]
N = int(input())
lst = [list(map(int, input().split())) for _ in range(N)]
# 상어의 위치를 담을 sr, sc
sr = 0
sc = 0
# 상어의 초기 사이즈
size = 2

# 먹은 물고기의 양을 담을 변수
eat_fish = 0
answer = 0
# 상어의 위치를 구하고 있던 자리를 0으로 바꿔준다.
for i in range(N):
    for j in range(N):
        if lst[i][j] == 9:
            sr = i
            sc = j

while True:
    min_V = 10e9
    # 상어 위치에서 bfs
    # return값이 있으면 최소거리가 저장된 min_V를 answer에 더해준다.
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