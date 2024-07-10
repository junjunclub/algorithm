import sys
input = sys.stdin.readline

N, M = map(int, input().split())
dict = {}
total = 0
for _ in range(N):
    dict[input().rstrip()] = 1
    total += 1
for _ in range(M):
    blog = input().rstrip().split(',')
    for w in blog:
        if w in dict.keys():
            if dict[w] == 1:
                total -= 1
                dict[w] = 0
    print(total)