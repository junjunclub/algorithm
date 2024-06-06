from heapq import heappush
from heapq import heappop
import sys
input = sys.stdin.readline
T = int(input())
pq = []
for _ in range(T):
    n = int(input())
    if n != 0:
        heappush(pq, (abs(n), n))
    else:
        try:
            print(heappop(pq)[1])
        except:
            print(0)