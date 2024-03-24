def prim(start):
    U = []
    D = [INF] * (N+1)

    D[start] = 0
    while len(U) < N:
        minV = INF
        for i in range(1,N+1):
            if i in U:
                continue

            if D[i] < minV:
                minV = D[i]
                start = i
        U.append(start)

        for i in range(1,N+1):
            if i in U:
                continue

            if graph[start][i]:
                D[i] = min(D[i], graph[start][i])
    print(sum(D[1:]))

N = int(input())
M = int(input())
INF = int(10e9)
graph = [[0]*(N+1) for _ in range(N+1)]
for _ in range(M):
    s, e, w = map(int, input().split())
    graph[s][e] = w
    graph[e][s] = w

prim(1)