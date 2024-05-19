N, M = map(int, input().split())
eng = {}
for _ in range(N):
    word = input()
    if word in eng:
        eng[word] +=1
    else:
        eng[word] = 1
lst = sorted(eng.items(), key=lambda item:(-item[1], -len(item[0]),item[0]))
# print(lst)

for i in lst:
    if len(i[0]) < M:
        continue
    else:
        print(i[0])