N = int(input())

lst = [list(map(int, input().split())) for _ in range(N)]

lst = sorted(lst)

for l in lst:
    print(*l)