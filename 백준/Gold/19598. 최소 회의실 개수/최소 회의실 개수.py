from heapq import heappush, heappop

T = int(input())
lst = []
for _ in range(T):
    s, e = map(int, input().split())
    lst.append((s, e))
lst.sort()

room = 0

pq = []
pq.append(lst[0][1])

for i in range(1, len(lst)):
    x, y = lst[i]
    if pq[0] <= x:
        heappop(pq)
    heappush(pq, y)
print(len(pq))
