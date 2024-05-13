T = int(input())
for _ in range(T):
    string = input()
    alphabet = ['A','B','C','D','E','F']
    answer = 'Infected!'
    word = ''
    if string[0] not in alphabet or string[-1] not in alphabet:
        answer = 'Good'
    else:
        idx = 0
        alphabet = ['A','F','C']
        word = 'A'
        for s in string[1:-1]:
            if word != s:
                idx += 1
                if alphabet[idx] != s:
                    answer = 'Good'
                    break
            word = s
    print(answer)