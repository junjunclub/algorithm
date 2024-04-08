def subsum(idx):
    if len(answer) == L:
        a, b = 0,0
        for j in answer:
            if j in ['a','e','i','o','u']:
                a += 1
            else:
                b += 1
        if a < 1 or b < 2:
            return
        else:
            print(''.join(answer))

    for i in range(idx, C):
        answer.append(lst[i])
        subsum(i+1)
        answer.pop()

L, C = map(int, input().split())
lst = list(input().split())
answer = []
lst.sort()

subsum(0)