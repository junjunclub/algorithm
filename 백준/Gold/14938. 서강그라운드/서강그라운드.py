import heapq

def dijk(start):
    pq = []
    heapq.heappush(pq, (0,start))
    D[start] = 0

    while pq:
        dist, node = heapq.heappop(pq)

        if dist > D[node]:
            continue

        for next_node in graph[node]:
            n_node = next_node[0]
            n_dist = next_node[1]

            distance = n_dist + dist

            if distance >= D[n_node]:
                continue

            if distance > M:
                continue

            D[n_node] = distance
            heapq.heappush(pq, (distance, n_node))


N, M, R = map(int, input().split())
lst = list(map(int, input().split()))
graph = [[] for _ in range(N+1)]
for _ in range(R):
    a, b, w = map(int, input().split())
    graph[a].append([b,w])
    graph[b].append([a,w])
# print(graph)
INF = 10e9
max_V = -10e9
for i in range(1,N+1):
    D = [INF]*(N+1)
    dijk(i)
    temp = 0
    for j in range(len(D)):
        if D[j] < 10e9:
            temp += lst[j-1]
    if temp > max_V:
        max_V = temp
print(max_V)