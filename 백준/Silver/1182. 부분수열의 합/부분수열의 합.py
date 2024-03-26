def subSum(lev, sumV):
    global answer

    if lev == N:
        if sum(result) == 0:
            return
        if sumV == S:
            answer += 1
        return

    result[lev] = 1
    subSum(lev+1, sumV+lst[lev])
    result[lev] = 0
    subSum(lev+1, sumV)

N, S = map(int, input().split())
lst = list(map(int, input().split()))
answer = 0
result = [0]*N
subSum(0,0)
print(answer)