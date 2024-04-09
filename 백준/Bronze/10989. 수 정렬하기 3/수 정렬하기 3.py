N = int(input())
lst = [0] * 10001
for _ in range(N):
    num = int(input())
    lst[num] += 1
for i in range(len(lst)):
    if lst[i] >= 1:
        for j in range(lst[i]):
            print(i)