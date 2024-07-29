K, L = map(int, input().split())
dict = {}
for i in range(L):
    word = input()
    if word in dict:
        dict.pop(word)
    dict[word] = 0

answer = list(dict.keys())
for i in range(min(K, len(answer))):
    print(answer[i])
