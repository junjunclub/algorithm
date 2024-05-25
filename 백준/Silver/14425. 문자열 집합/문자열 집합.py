N, M = map(int, input().split())
dict = {}
for _  in range(N):
    text = input()
    dict[text] = 0

for _ in range(M):
    value = input()
    if value in dict:
        dict[value] += 1
answer = 0
for value in dict.values():
    answer += value
print(answer)