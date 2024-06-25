pipe = list(input())

ST = []
answer = 0
num = 0
idx = 0

while idx < len(pipe):
    # 열리는 괄호일 때,
    if pipe[idx] == '(':
        # 레이저일 때,
        if pipe[idx+1] == ')':
            answer += num
            idx += 1
        # 파이프일 때,
        else:
            num += 1
    else:
        num -= 1
        answer += 1
    idx += 1
print(answer)