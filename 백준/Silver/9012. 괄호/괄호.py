T = int(input())

for _ in range(T):
    s = input()
    ST = []
    for c in s:
        if c == '(':
            ST.append(c)
        elif c == ')' and ST: # c == ')':
            if ST[-1] == '(':
                ST.pop()
        else:
            ST.append(c)
    if ST:
        print('NO')
    else:
        print('YES')