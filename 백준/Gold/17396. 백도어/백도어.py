from heapq import heappop, heappush

def dijk(start):
    pq = []
    heappush(pq, (0, start))

    while pq:
        dist, node = heappop(pq)

        if D[node] < dist:
            continue

        for n_dist, n_node in graph[node]:
            sum_dist = n_dist + dist

            if sum_dist >= D[n_node]:
                continue

            if lst[n_node] == 1 and n_node != (N-1):
                continue

            heappush(pq, (sum_dist, n_node))
            D[n_node] = sum_dist

N, M = map(int, input().split())
lst = list(map(int, input().split()))
graph = [[] for _ in range(N)]
INF = 10e9
D = [INF]*N
for _ in range(M):
    a, b, w = map(int, input().split())
    graph[a].append((w,b))
    graph[b].append((w,a))
# print(graph)

dijk(0)

if D[-1] == INF:
    print(-1)
else:
    print(D[-1])