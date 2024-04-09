def bfs(r, c):
    global check
    for dr, dc in [(0,1),(0,-1),(1,0),(-1,0)]:
        newR = r+dr
        newC = c+dc
        if 0<=newR<R and 0<=newC<C:
            if lst[newR][newC] == '.':
                check[r][c] += 1
        else:
            check[r][c] += 1


R, C = map(int, input().split())
lst = [list(input()) for _ in range(R)]
check = [[0]*C for _ in range(R)]
minx = 10e9
miny = 10e9
maxx = -10e9
maxy = -10e9
cnt = 0

for i in range(R):
    for j in range(C):
        if lst[i][j] == 'X':
            bfs(i,j)
for i in range(R):
    for j in range(C):
        if check[i][j] >= 3:
            lst[i][j] = '.'
        if lst[i][j] == 'X':
            if minx > i:
                minx = i
            if miny > j:
                miny = j
            if maxx < i:
                maxx = i
            if maxy < j:
                maxy = j
            cnt += 1
# print(minx, miny, maxx, maxy)
# print(lst)
if cnt == 0:
    print('X')
else:
    for k in range(R):
        answer = []
        for l in range(C):
            if minx<=k<=maxx and miny<=l<=maxy:
                answer.append(lst[k][l])
        if answer:
            print(''.join(answer))