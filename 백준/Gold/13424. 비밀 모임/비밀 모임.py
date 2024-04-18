from heapq import heappop, heappush

def dijk(start):
    D[start] = 0
    pq = []
    heappush(pq, (0, start))

    while pq:
        dist, node = heappop(pq)

        # 거리가 현재 거리보다 멀다면 컨티뉴
        if dist > D[node]:
            continue

        for nextdist, nextnode in graph[node]:
            total_dist = nextdist+dist

            # 다음 노드의 거리가 현재거리보다 짧다면 갈 필요 없음
            if D[nextnode] < total_dist:
                continue
            D[nextnode] = total_dist
            heappush(pq, (total_dist,nextnode))

T = int(input())
for _ in range(T):
    N, M = map(int, input().split())
    graph = [[] for _ in range(N+1)]
    for _ in range(M):
        a, b, w = map(int, input().split())
        graph[a].append((w,b))
        graph[b].append((w,a))
    K = int(input())
    lst = list(map(int, input().split()))
    INF = 10e9
    min_V = INF
    answer = 0
    for i in range(1,N+1):
        D = [INF]*(N+1)
        dijk(i)
        tmp = 0
        # print(D)
        for j in lst:
            tmp += D[j]
        # print(tmp)
        if tmp < min_V:
            min_V = tmp
            answer = i
    print(answer)