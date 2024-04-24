N, K = map(int, input().split())
lst = list(range(2, N+1))
visited = [0]*(N+2)
cnt = 0
for i in range(2,N+1):
    for j in range(i, N+1, i):
        if not visited[j]:
            visited[j] = 1
            cnt += 1
            if cnt == K:
                print(j)