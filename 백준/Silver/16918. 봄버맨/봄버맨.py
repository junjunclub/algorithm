R, C, N = map(int, input().split())
lst = [list(input()) for _ in range(R)]

all_bomb_lst = [['O']*C for _ in range(R)]

all_lst = [['O']*C for _ in range(R)]

bomb = []
second_bomb = []

# 처음 리스트에서 폭탄인거 bomb에 넣어준다.
for i in range(R):
    for j in range(C):
        if lst[i][j] == 'O':
            bomb.append((i,j))

# 처음 리스트에서 폭탄이 터진 리스트 만들기.
while bomb:
    vr, vc = bomb.pop()
    all_lst[vr][vc] = '.'

    for dr, dc in [(0,1),(0,-1),(1,0),(-1,0)]:
        newR = dr+vr
        newC = dc+vc

        if 0<=newR<R and 0<=newC<C:
            all_lst[newR][newC] = '.'




if N % 2 == 0:
    for r in all_bomb_lst:
        print(*r, sep='')
elif N == 1:
    for r in lst:
        print(*r, sep='')
elif N%4 == 3:
    for r in all_lst:
        print(*r, sep='')
else:
    for r in range(len(all_lst)):
        for c in range(len(all_lst[r])):
            if all_lst[r][c] == 'O':
                second_bomb.append((r,c))

    while second_bomb:
        obr, obc = second_bomb.pop()
        all_bomb_lst[obr][obc] = '.'

        for dr, dc in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
            newObr = dr + obr
            newObc = dc + obc

            if 0 <= newObr < R and 0 <= newObc < C:
                all_bomb_lst[newObr][newObc] = '.'
    for k in all_bomb_lst:
        print(*k, sep='')



# 0초, 초기 폭탄 설치

# 1초, 나머지 공간 폭탄 설치(모든 공간 폭탄 존재)

# 2초, 초기 폭탄 폭발

# 3초, 초기 폭탄 설치(모든 공간 폭탄 존재)

# 4초, 나머지 공간 폭탄 폭발(0초랑 상태가 같다.)