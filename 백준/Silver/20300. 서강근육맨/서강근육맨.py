N = int(input())
lst = list(map(int, input().split()))

lst.sort()
muscle = []
s = 0
e = len(lst)-1
while s < len(lst) // 2:
    # 홀수일 때
    if len(lst)%2:
        muscle.append(lst[s]+lst[e-s-1])
    # 짝수일 때
    else:
        muscle.append(lst[s]+lst[e-s])
    s += 1
if len(lst)%2:
    muscle.append(lst[-1])
print(max(muscle))


