from collections import deque

N = int(input())
lst = list(map(int, input().split()))

if N == 1:
    print(0)
else:
    # bfs
    visited = [0] * (N + 1)
    queue = deque([1])

    while queue:
        x = queue.popleft()
        if x + lst[x-1] >= N:
            print(visited[x] + 1)
            break
        for i in range(1, lst[x-1]+1):
            nx = x+i
            if visited[nx] == 0:
                queue.append(nx)
                visited[nx] = visited[x] + 1
    else:
        print(-1)