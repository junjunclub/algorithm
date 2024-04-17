from heapq import heappop, heappush

def dijk(start):
    D[start] = 0
    pq = []
    heappush(pq, (0, start))

    while pq:
        value, point = heappop(pq)

        if D[point] < value:
            continue

        for next_D, next_node in graph[point]:
            new_D = value + next_D

            if D[next_node] <= new_D:
                continue

            D[next_node] = new_D
            heappush(pq, (new_D, next_node))
            # print(D)


N, M = map(int, input().split())
graph = [[] for _ in range(N+1)]
INF = 10e9
D = [INF]*(N+1)
for _ in range(M):
    a, b, w = map(int, input().split())
    graph[a].append((w,b))
    graph[b].append((w,a))

dijk(1)
print(D[N])