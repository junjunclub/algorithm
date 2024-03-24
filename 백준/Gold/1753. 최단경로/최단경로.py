import heapq

def dijk(start):
    pq = []
    heapq.heappush(pq, (0,start))
    distance[start] = 0

    while pq:
        dist, now = heapq.heappop(pq)

        if distance[now] < dist:
            continue

        for next in graph[now]:
            next_node = next[0]
            cost = next[1]

            new_cost = dist+cost

            if new_cost >= distance[next_node]:
                continue

            distance[next_node] = new_cost
            heapq.heappush(pq, (new_cost,next_node))

INF = 10e9
V, E = map(int, input().split())
K = int(input())

graph = [[] for _ in range(V+1)]
distance = [INF] * (V+1)

for _ in range(E):
    s, e, w = map(int, input().split())
    graph[s].append([e, w])
# print(graph)
dijk(K)
for val in distance[1:]:
    if val == INF:
        print('INF')
    else:
        print(val)