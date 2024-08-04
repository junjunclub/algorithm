N = int(input())
lst = [0]*366
for _ in range(N):
    s, e = map(int, input().split())
    for i in range(s, e+1):
        lst[i] += 1

answer = 0
row = 0
col = 0

for day in lst:
    if day:
        col = max(col, day)
        row += 1
    else:
        answer += row * col
        row = 0
        col = 0
answer += row * col
print(answer)