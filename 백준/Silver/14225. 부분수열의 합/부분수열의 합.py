def subsum(lev, sumV):
    if lev == N:
        if sum(result) == 0:
            return
        temp = 0
        for i in range(N):
            if result[i]:
                temp += lst[i]
        answer.append(temp)
        return

    result[lev] = 1
    subsum(lev+1, sumV+lst[lev])
    result[lev] = 0
    subsum(lev+1, sumV)



N = int(input())
lst = list(map(int, input().split()))
result = [0]*N
answer = []
subsum(0, 0)

set_lst = list(set(answer))
set_lst.sort()
arr = [i for i in range(1,sum(lst)+2)]
# print(arr)
# print(set_lst)
for i in range(len(set_lst)):
    if arr[i] != set_lst[i]:
        print(arr[i])
        break
else:
    print(arr[-1])