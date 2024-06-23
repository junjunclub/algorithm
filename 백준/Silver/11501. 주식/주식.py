T = int(input())
for _ in range(T):
    N = int(input())
    lst = list(map(int, input().split()))
    answer = 0
    max_value = lst[N-1]
    for i in range(N-1, -1, -1):
        # 최댓값 갱신
        if lst[i] > max_value:
            max_value = lst[i]
        # i번째 값이 그 전값보다 큰 경우
        if lst[i] < max_value:
            answer += max_value - lst[i]
    print(answer)