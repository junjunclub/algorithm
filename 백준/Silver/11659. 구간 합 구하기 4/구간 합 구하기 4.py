import sys
input = sys.stdin.readline

N, M = map(int, input().split())
lst = list(map(int, input().split()))
L = len(lst)
answer = [0]

tmp = 0
for i in lst:
    tmp += i
    answer.append(tmp)
for _ in range(M):
    a, b = map(int, input().split())
    print(answer[b]-answer[a-1])