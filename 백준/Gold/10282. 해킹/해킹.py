from heapq import heappop, heappush

def dijk(start, graph):
    pq = []
    heappush(pq, (0, start))
    D[c] = 0

    while pq:
        dist, node = heappop(pq)

        if D[node] < dist:
            continue

        for next_node, distance in graph[node]:
            value = D[node]+distance
            if D[next_node] <= value:
                continue

            heappush(pq, (value, next_node))
            D[next_node] = value

T = int(input())
for _ in range(T):
    n, d, c = map(int, input().split())
    graph = [[] for _ in range(n+1)]
    inf = 10e9
    D = [inf]*(n+1)
    for _ in range(d):
        # b가 감염되면 a도 감염됨
        a, b, s = map(int, input().split())
        graph[b].append((a,s))
    dijk(c, graph)
    cnt = 0
    result = 0
    for v in D:
        if v != inf:
            cnt += 1
            if v > result:
                result = v
    print(cnt, result)