N, M = map(int, input().split())
r, c, d = map(int, input().split())
lst = [list(map(int, input().split())) for _ in range(N)]
delta = [(-1,0),(0,1),(1,0),(0,-1)]
vr = r
vc = c
answer = 0
while True:
    # 현재 칸이 청소가 안돼있다면 청소를 한다.
    # 현재 칸 청소여부에 따라 check_now의 상태를 변경해준다.
    # 청소한 칸은 2로..
    check_now = False
    if lst[vr][vc] == 0:
        lst[vr][vc] = 2
        answer += 1
        check_now = True
    check_4d = False
    for dr, dc in delta:
        newR = dr+vr
        newC = dc+vc
        # 4방향 중 청소를 안한 칸이 있다면 check_4d를 True로,
        if lst[newR][newC] == 0:
            check_4d = True
    # check_4d가 True면 반시계방향으로 회전한다.
    # 만약 반시계 방향으로 전환을 했는데, 빈칸이 아니라면, 계속 반시계 방향으로 방향을 전환한다.
    if check_4d:
        d = (d - 1) % 4
        while lst[vr+delta[d][0]][vc+delta[d][1]] != 0:
            d = (d - 1) % 4
        vr = vr + delta[d][0]
        vc = vc + delta[d][1]
    # 만약 사방이 청소가 된 상태라면
    elif check_4d == False:
        # 방향은 유지하고, 그 방향 기준으로 1칸 뒤로 간다
        vr = vr - delta[d][0]
        vc = vc - delta[d][1]
        if lst[vr][vc] == 1:
            break

print(answer)