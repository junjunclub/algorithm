from heapq import heappush, heappop

N = int(input())
pq = []
for _ in range(N):
    heappush(pq, int(input()))
sumV = 0
while len(pq) > 1:
    x = heappop(pq)
    y = heappop(pq)
    tmp = x + y
    sumV += tmp
    heappush(pq, tmp)
print(sumV)