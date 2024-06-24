N, H = map(int, input().split())

up = [0] * (H+1)
down = [0] * (H+1)

for i in range(N):
    obstacle = int(input())
    # 종유석이면
    if i%2:
        down[obstacle] += 1
    # 석순이면
    else:
        up[obstacle] += 1

# 작은것부터 더해주기
for i in range(H-1,0,-1):
    down[i] += down[i+1]
    up[i] += up[i+1]

min_v = N
cnt = 0

for i in range(1,H+1):
    if min_v > down[i]+up[H-i+1]:
        min_v = down[i]+up[H-i+1]
        cnt = 1
    elif min_v == down[i]+up[H-i+1]:
        cnt += 1
print(min_v, cnt)