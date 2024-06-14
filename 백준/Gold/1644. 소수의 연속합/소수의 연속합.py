def prime_num(n):
    arr = [i for i in range(n+1)]
    end = int(n**(1/2))

    for i in range(2, end+1):
        if arr[i] == 0:
            continue
        for j in range(i*i, n+1, i):
            arr[j] = 0

    prime_num = []

    for i in range(2, len(arr)):
        if arr[i]:
            prime_num.append(arr[i])

    return prime_num

N = int(input())

cnt = 0
lst = prime_num(N)

s = 0
e = len(lst)

while s<=e:
    temp = 0
    for i in range(e-1, s-1, -1):
        temp += lst[i]
        if temp > N:
            e -= 1
            break
        elif temp == N:
            cnt += 1
            e -= 1
            break
    else:
        break
print(cnt)
