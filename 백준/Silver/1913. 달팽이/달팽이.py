N = int(input())
num = int(input())

lst = [[0]*N for _ in range(N)]
d = [[-1,0],[0,1],[1,0],[0,-1]]
idx = 0
nx = N//2
ny = N//2
start = 1
cx = 0
cy = 0
while start != N*N+1:
    if start == num:
        cx = nx
        cy = ny
    lst[nx][ny] = start
    nx += d[idx][0]
    ny += d[idx][1]
    newX = nx + d[(idx+1)%4][0]
    newY = ny + d[(idx+1)%4][1]

    if lst[newX][newY] == 0 and 0<=nx<N and 0<=ny<N:
        idx = (idx + 1)%4
    start += 1
for i in lst:
    print(*i)
print(cx+1, cy+1)


