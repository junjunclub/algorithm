N = int(input())
dict = {}
for _ in range(N):
    num = int(input())
    dict[num] = dict.get(num, 0) + 1

answer = sorted(dict.items(), key=lambda x: (-x[1], x[0]))
print(answer[0][0])