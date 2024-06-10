N, K = map(int, input().split())
level = []
for _ in range(N):
    level.append(int(input()))

s = min(level)
e = s+K
answer = s
while s<=e:
    m = (s+e)//2
    value = K
    for i in level:
        if i < m:
            value -= (m-i)
    if value < 0:
        e = m-1
    else:
        s = m+1
        answer = max(m, answer)
print(answer)