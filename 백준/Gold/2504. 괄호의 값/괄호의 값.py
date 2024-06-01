lst = list(input())
ST = []
# 곱셈 배율
multiple = 1
answer = 0
for i in range(len(lst)):
    if lst[i] == '(':
        multiple *= 2
        ST.append(lst[i])
    # 닫히면 배율 * 2
    elif lst[i] == ')':
        # 스택 안에 값이 있으면 배율 * 2
        if not ST or ST[-1] == '[':
            answer = 0
            break
        if lst[i-1] == '(':
            answer += multiple
        multiple //= 2
        ST.pop()
    elif lst[i] == '[':
        multiple *= 3
        ST.append(lst[i])
    elif lst[i] == ']':
        if not ST or ST[-1] == '(':
            answer = 0
            break
        if lst[i-1] == '[':
            answer += multiple
        multiple //= 3
        ST.pop()
if ST:
    print(0)
else:
    print(answer)