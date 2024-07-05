N = int(input())
dict = {}
answer = 0
for _ in range(N):
    word = input()
    if word == 'ENTER':
        dict = {}
    else:
        if word in dict:
            continue
        else:
            dict[word] = 1
            answer += 1
print(answer)