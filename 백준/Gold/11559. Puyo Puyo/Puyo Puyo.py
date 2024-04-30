from collections import deque

def bfs(r,c):
    q = deque()
    q.append((r,c))
    visited[r][c] = 1
    temp = []
    while q:
        vr, vc = q.popleft()

        for dr, dc in [(0,1),(0,-1),(1,0),(-1,0)]:
            newR = dr+vr
            newC = dc+vc

            if 0<=newR<12 and 0<=newC<6 and not visited[newR][newC] and lst[newR][newC] == lst[vr][vc]:
                visited[newR][newC] = 1
                q.append((newR,newC))
                temp.append((newR,newC))
    # 3개 이상 같으면 자기자신까지 temp에 넣어주고 answer에 extend(없어지는 뿌요)
    if len(temp) >= 3:
        temp.append((r,c))
        puyo.extend(temp)


lst = [list(input()) for _ in range(12)]

cnt = 0
while True:
    # 반복문이 한번 돌때 없어지는 뿌요들을 담을 배열
    puyo = []
    visited = [[0]*6 for _ in range(12)]
    for i in range(12):
        for j in range(6):
            if lst[i][j] != '.':
                bfs(i,j)
    # 뿌요가 있으면 cnt + 1, 없으면 break
    if puyo:
        cnt += 1
    else:
        break
    for row, col in puyo:
        lst[row][col] = '.'

    # 뿌요들 아래로 내려줘야함
    down = [-1,-1,-1,-1,-1,-1]
    for k in range(11, -1, -1):
        for l in range(6):
            # 아래칸부터 .인 칸을 down에 담아준다
            if lst[k][l] == '.':
                down[l] = max(k,down[l])
            # 아래로 내릴 수 있고, lst[k][l]이 뿌요라면
            elif down[l] >= 0 and lst[k][l] != '.':
                lst[down[l]][l] = lst[k][l]
                lst[k][l] = '.'
                down[l] -= 1
# print(lst)
print(cnt)