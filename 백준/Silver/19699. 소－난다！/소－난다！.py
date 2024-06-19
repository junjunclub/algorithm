from itertools import combinations

def is_prime(n):
    i = 2
    while i**2 <= n:
        if n%i == 0:
            return False
        i += 1
    return True

N, M = map(int, input().split())
lst = list(map(int, input().split()))

comb = list(combinations(lst,M))
cow_set = set()
for cow in comb:
    sum_v = sum(cow)
    if is_prime(sum_v):
        cow_set.add(sum_v)

answer = sorted(list(cow_set))
if not answer:
    print(-1)
else:
    for i in answer:
        print(i, end=' ')