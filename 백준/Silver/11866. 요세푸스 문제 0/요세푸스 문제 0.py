from collections import deque

N, K = map(int, input().split())
lst = list(range(1, N+1))
pos = 0
r = N
print("<", end = "")
for i in range(r):
    pos += K-1
    pos %= N

    N -= 1
    if i == r-1:
        print(lst.pop(pos), end=">")
    else:
        print(f"{lst.pop(pos)},", end = " ")
