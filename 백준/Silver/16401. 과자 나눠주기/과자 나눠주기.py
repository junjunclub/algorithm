M, N = map(int, input().split())
lst = list(map(int, input().split()))
start = 1
end = 1000000000
answer = 0
while start <= end:
    mid = (start+end)//2
    long = 0
    for i in lst:
        long += i//mid
    # 길이가 충분할 때(과자 양 늘려보기)
    if long >= M:
        start = mid+1
        answer = max(answer, mid)
    # 길이가 충분하지 않을 때(과자 양 줄이기)
    else:
        end = mid-1
print(answer)