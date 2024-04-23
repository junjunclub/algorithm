from collections import deque


N, M = map(int, input().split())
dice = [0]*106
step = []
for _ in range(N+M):
    s1, e1 = map(int, input().split())
    step.append((s1, e1))

q = deque()
q.append(1)
while q:
    v = q.popleft()

    if v == 100:
        print(dice[100])
        break

    for newV in range(v+1, v+7):
        for s, e in step:
            if s == newV:
                newV = e

        if not dice[newV]:
            dice[newV] = dice[v] + 1
            q.append(newV)