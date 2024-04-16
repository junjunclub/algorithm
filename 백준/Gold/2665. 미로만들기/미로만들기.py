from heapq import heappop, heappush
def dijk(value, r, c):
    pq = []
    heappush(pq, (value, r,c))
    D[r][c] = value

    while pq:
        vv, vr, vc = heappop(pq)

        if D[vr][vc] < vv:
            return

        for dr, dc in [(1,0),(-1,0),(0,1),(0,-1)]:
            newR = dr+vr
            newC = dc+vc

            if 0<=newR<N and 0<=newC<N:
                if lst[newR][newC] == 0:
                    if D[newR][newC] <= vv:
                        continue
                    else:
                        D[newR][newC] = vv+1
                        heappush(pq, (D[newR][newC],newR,newC))
                elif lst[newR][newC] == 1:
                    if D[newR][newC] <= vv:
                        continue
                    else:
                        D[newR][newC] = vv
                        heappush(pq, (D[newR][newC],newR, newC))







N = int(input())
lst = [list(map(int, input())) for _ in range(N)]
INF = 10e9
D = [[INF]*N for _ in range(N)]

dijk(0,0,0)
print(D[N-1][N-1])