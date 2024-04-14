N, M = map(int, input().split())
dict = {}
for _ in range(N):
    site, pwd = input().split()
    dict[site] = pwd

for _ in range(M):
    s = input()
    print(dict[s])