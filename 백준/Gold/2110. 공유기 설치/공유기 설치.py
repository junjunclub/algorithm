N, C = map(int, input().split())
router = []
for _ in range(N):
    router.append(int(input()))
router.sort()

s = 1
e = router[-1]-router[0]

while s <= e:
    mid = (s+e)//2
    now = router[0]
    cnt = 1
    for i in range(1,N):
        if router[i] >= now + mid:
            cnt += 1
            now = router[i]
    # 설치 가능한 공유기 갯수보다 많은 경우
    # 거리 늘리기
    if cnt >= C:
        s = mid+1
    # 설치 가능한 공유기 갯수보다 적은 경우
    # 거리를 줄여도 된다.
    else:
        e = mid-1
print(e)
