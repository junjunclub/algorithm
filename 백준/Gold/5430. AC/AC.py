from collections import deque
T = int(input())
for _ in range(T):
    func = input()
    n = int(input())
    tmp_lst = input()[1:-1]
    r = 0
    try:
        answer = deque(list(map(int, tmp_lst.split(','))))
    except:
        answer = deque()

    for i in func:
        if i == 'R':
            if r:
                r = 0
            else:
                r = 1
        elif i == 'D':
            if answer:
                if r:
                    answer.pop()
                else:
                    answer.popleft()
            else:
                print('error')
                break
    else:
        if answer:
            print('[', end='')
        else:
            print("[]")
            continue
        if r:
            temp = answer
            temp.reverse()
            answer = temp
            for j in range(len(answer)):
                if j == len(answer)-1:
                    print(answer[j],']', sep='')
                else:
                    print(answer[j],',', sep='', end='')
        else:
            for j in range(len(answer)):
                if j == len(answer)-1:
                    print(answer[j],']', sep='')
                else:
                    print(answer[j],',', sep='', end='')