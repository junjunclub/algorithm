from heapq import heappop, heappush

def dijk(S, E):
    D[S] = 0
    pq = []
    heappush(pq, (0,S))

    while pq:
        dist, node = heappop(pq)

        if dist > D[node]:
            continue

        for next in graph[node]:
            next_dist = next[0]
            next_node = next[1]

            distance = next_dist + dist

            if distance >= D[next_node]:
                continue

            heappush(pq, (distance, next_node))
            D[next_node] = distance
    return D[E]


V, E, P = map(int, input().split())
graph = [[] for _ in range(V+1)]
INF = 10e9
D = [INF]*(V+1)
for _ in range(E):
    s, e, w = map(int, input().split())
    graph[s].append((w,e))
    graph[e].append((w,s))

if dijk(1, V) == dijk(1, P)+dijk(P,V):
    print('SAVE HIM')
else:
    print('GOOD BYE')
