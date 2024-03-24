import heapq


def dijk(start):
    pq = []
    heapq.heappush(pq, ((0, start)))
    distance[start] = 0

    while pq:
        dist, now = heapq.heappop(pq)

        if distance[now] < dist:
            continue

        for next in graph[now]:
            next_node = next[0]
            cost = next[1]

            new_cost = dist + cost

            if new_cost >= distance[next_node]:
                continue

            distance[next_node] = new_cost
            heapq.heappush(pq, (new_cost, next_node))


N = int(input())
M = int(input())
graph = [[] for _ in range(N + 1)]
INF = 10e9
distance = [INF] * (N + 1)
for _ in range(M):
    s, e, w = map(int, input().split())
    graph[s].append([e, w])
sp, ep = map(int, input().split())
# print(graph)
dijk(sp)
print(distance[ep])
