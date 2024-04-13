from heapq import heappop, heappush

def dijk(r, c):
    pq = []
    heappush(pq, (lst[r][c], r, c))
    dist[0][0] = lst[0][0]

    while pq:
        value, vr, vc = heappop(pq)

        if dist[vr][vc] < value:
            continue

        for dr, dc in [(1,0),(0,1),(-1,0),(0,-1)]:
            newR = dr+vr
            newC = dc+vc

            if 0<=newR<T and 0<=newC<T:
                n_value = value+lst[newR][newC]

                if n_value >= dist[newR][newC]:
                    continue

                dist[newR][newC] = n_value
                heappush(pq, (n_value, newR,newC))

TC = 0
while True:
    T = int(input())
    if T == 0:
        break
    TC += 1
    lst = [list(map(int, input().split())) for _ in range(T)]
    INF = 10e9
    dist = [[INF]*T for _ in range(T)]
    dijk(0,0)
    print(f'Problem {TC}: {dist[T-1][T-1]}')
