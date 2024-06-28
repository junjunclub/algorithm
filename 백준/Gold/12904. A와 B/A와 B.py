S = list(input())
T = list(input())

# S랑 T가 다를 때까지 반복
while len(S) < len(T):
    # T의 제일 뒤가 A 일때,
    if T[-1] == 'A':
        T.pop()
    # T의 제일 뒤가 B 일때,
    else:
        T.pop()
        temp = T
        temp = temp[::-1]
        T = temp

if S == T:
    print(1)
else:
    print(0)