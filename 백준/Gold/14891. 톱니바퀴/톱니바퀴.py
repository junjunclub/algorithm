# n번째 톱니를 시계방향으로 돌리는 함수
def clockwise(n):
    # 시계 방향으로 돌림
    temp = [mac[n][-1]] + mac[n]
    temp = temp[:8]
    mac[n] = temp
    return

# n번째 톱니를 반시계방향으로 돌리는 함수
def counter_clockwise(n):
    # 반 시계방향으로 돌림
    temp = mac[n] + [mac[n][0]]
    temp = temp[1:]
    mac[n] = temp
    return


mac = [list(map(int, input())) for _ in range(4)]
N = int(input())
for _ in range(N):
    S, D = map(int, input().split())
    check = [0]*4
    idx = S-1
    check[idx] = D
    # 앞에 위치한 톱니바퀴 체크
    while idx < 3:
        if mac[idx][2] != mac[idx+1][6]:
            check[idx+1] = check[idx]*-1
            idx += 1
        else:
            break
    while idx > 0:
        if mac[idx][6] != mac[idx-1][2]:
            check[idx-1] = check[idx] * -1
            idx -= 1
        else:
            break
    # print(check)
    for i in range(len(check)):
        if check[i] == -1:
            counter_clockwise(i)
        elif check[i] == 1:
            clockwise(i)
    # print(mac)
result = 0
for i in range(len(mac)):
    if mac[i][0] == 1:
        result += 2**i
print(result)
