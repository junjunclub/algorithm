from collections import deque

R, C = map(int, input().split())
lst = [list(input()) for _ in range(R)]
visited_f = [[0]*C for _ in range(R)]
visited_h = [[0]*C for _ in range(R)]
a_visited = [[0]*C for _ in range(R)]
ax = 0
ay = 0
hover = deque()
flood = deque()
# print(lst)
for i in range(R):
    for j in range(C):
        if lst[i][j] == '*':
            flood.append((i,j,1))
        elif lst[i][j] == 'S':
            hover.append((i,j,1))
        elif lst[i][j] == 'D':
            ax = i
            ay = j
while flood:
    vr, vc , vv = flood.popleft()
    visited_f[vr][vc] = vv
    for dr, dc in [(0,1),(0,-1),(1,0),(-1,0)]:
        newR = vr+dr
        newC = vc+dc
        if 0<=newR<R and 0<=newC<C and not visited_f[newR][newC] and lst[newR][newC] != 'D' and lst[newR][newC] != 'X':
            flood.append((newR,newC,vv+1))
            visited_f[newR][newC] = vv+1
while hover:
    hr, hc, hv = hover.popleft()
    visited_h[hr][hc] = hv
    for dr, dc in [(0,1),(0,-1),(1,0),(-1,0)]:
        newhR = hr+dr
        newhC = hc+dc
        if 0<=newhR<R and 0<=newhC<C and not visited_h[newhR][newhC] and lst[newhR][newhC] != 'X':
            if visited_f[newhR][newhC] == 0 or hv+1 < visited_f[newhR][newhC] or lst[newhR][newhC] == 'D':
                hover.append((newhR,newhC,hv+1))
                visited_h[newhR][newhC] = hv+1
# print(visited_h)
# print(visited_f)
if visited_h[ax][ay]-1 < 0:
    print('KAKTUS')
else:
    print(visited_h[ax][ay]-1)