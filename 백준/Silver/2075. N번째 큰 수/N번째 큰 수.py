from heapq import heappush, heappop

N = int(input())
pq = []
for _ in range(N):
    arr = list(map(int, input().split()))
    for i in arr:
        if len(pq) < N:
            heappush(pq, i)
        else:
            if pq[0] < i:
                heappop(pq)
                heappush(pq, i)
print(pq[0])