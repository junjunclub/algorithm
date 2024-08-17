def prime(num):
    if num == 1:
        return False
    else:
        for j in range(2, int(num**0.5)+1):
            if num % j == 0:
                return False
        return True

while True:
    cnt = 0
    n = int(input())
    if n == 0:
        break

    for i in range(n+1, 2*n+1):
        if prime(i):
            cnt += 1
    print(cnt)