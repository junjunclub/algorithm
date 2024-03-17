import math

def num(n):
    if (n-int(n)) >= 0.5:
        return int(n)+1
    else:
        return int(n)

N = int(input())
if N == 0:
    print(0)
else:
    lst = []
    s = num(N*0.15)
    # print(s)
    for _ in range(N):
        lst.append(int(input()))
    lst.sort()
    answer = lst[s:N-s]
    print(num(sum(answer)/len(answer)))