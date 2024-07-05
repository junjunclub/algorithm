import sys
input = sys.stdin.readline

N, M, Q = map(int, input().split())

graph = [[] for _ in range(N+1)]
visited1 = [0]*(N+1)
visited2 = [0]*(N+1)
for _ in range(M):
    s, e = map(int, input().split())
    graph[s].append(e)
    graph[e].append(s)
# print(graph)

for _ in range(Q):
    num = int(input())
    answer = 0
    if visited2[num]:
        print(0)
        continue
    else:
        visited2[num] = 1

    if not visited1[num]:
        answer += 1
        visited1[num] = 1
    for i in graph[num]:
        if not visited1[i]:
            answer += 1
            visited1[i] = 1
    print(answer)