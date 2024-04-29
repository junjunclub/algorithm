N, K = map(int, input().split())
lst = []

for _ in range(N):
    lst.append(int(input()))

start = 1
end = max(lst)
answer = 0
while start <= end:
    temp = 0
    mid = (start+end) // 2

    for i in range(N):
        temp += lst[i]//mid

    # 임시로 저장한 값이 사람수보다 많은 경우(막걸리 잔이 더 많이 나온 경우)
    # 막걸리 양을 늘려야함
    if temp >= K:
        start = mid+1
        answer = max(answer, mid)
    # 사람수보다 잔이 부족한 경우(막걸리 양을 줄여야함)
    else:
        end = mid-1
print(answer)