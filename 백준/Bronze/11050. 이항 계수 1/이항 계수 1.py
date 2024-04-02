from itertools import combinations

N, K = map(int, input().split())

print(len(list(combinations(range(1, N+1), K))))