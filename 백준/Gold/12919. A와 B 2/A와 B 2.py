def dfs(word):
    global result
    
    if word == S:
        result = 1
        return
    if len(word) < len(S):
        return


    if word[-1] == 'A':
        dfs(word[:-1])
    if word[0] == 'B':
        dfs(word[1:][::-1])


result = 0
S = input()
T = input()

dfs(T)

print(result)