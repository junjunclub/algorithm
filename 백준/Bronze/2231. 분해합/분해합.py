N = int(input())
for i in range(1, N):
    total = i
    for num in str(i):
        total += int(num)
    if total == N:
        print(i)
        break
else:
    print(0)