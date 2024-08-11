N, L = map(int, input().split())
answer = 0
now = 0
for _ in range(N):
    D, R, G = map(int, input().split())
    answer += (D-now)
    now = D
    if answer % (R+G) <= R:
        answer += (R - (answer % (R+G)))
answer += L - now
print(answer)