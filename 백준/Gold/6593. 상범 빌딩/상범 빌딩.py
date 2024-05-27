from collections import deque

def bfs(x, y, z):
    q = deque()
    q.append((x, y, z))
    visited[x][y][z] = 1

    while q:
        vx, vy, vz = q.popleft()
        if building[vx][vy][vz] == 'E':
            return

        for dx, dy, dz in [(0,0,1),(0,0,-1),(1,0,0),(-1,0,0),(0,1,0),(0,-1,0)]:
            newX = vx+dx
            newY = vy+dy
            newZ = vz+dz
            if 0<=newX<L and 0<=newY<R and 0<=newZ<C and not visited[newX][newY][newZ] and building[newX][newY][newZ] != '#':
                visited[newX][newY][newZ] = visited[vx][vy][vz] + 1
                q.append((newX,newY,newZ))
                # print(visited)

while True:
    L, R, C = map(int, input().split())
    if L == 0 and R == 0 and C == 0:
        break
    building = []
    visited = [[[0]*C for _ in range(R)] for _ in range(L)]
    for _ in range(L):
        temp = [list(input()) for _ in range(R)]
        space = input()
        building.append(temp)
    x, y, z = -1, -1, -1
    ex, ey, ez = -1,-1,-1
    for i in range(L):
        for j in range(R):
            for k in range(C):
                if building[i][j][k] == 'S':
                    x = i
                    y = j
                    z = k
                if building[i][j][k] == 'E':
                    ex = i
                    ey = j
                    ez = k
    # print(ex, ey, ez)

    # print(building)
    # print(visited)
    bfs(x, y, z)
    # print(visited)
    if visited[ex][ey][ez]:
        print('Escaped in',visited[ex][ey][ez]-1,'minute(s).')
    else:
        print('Trapped!')