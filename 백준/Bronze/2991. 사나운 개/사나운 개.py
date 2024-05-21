A, B, C, D = map(int, input().split())
P, M, N = map(int, input().split())
max_num = max(P,M,N)
# print(max_num)
lst = [0]*1000
idx1 = 1
idx2 = 1
while idx1<=999:
    for _ in range(A):
        lst[idx1] += 1
        idx1 += 1
    idx1 += B
    if max_num < idx1:
        break

while idx2<=999:
    for _ in range(C):
        lst[idx2] += 1
        idx2 += 1
    idx2 += D
    if max_num < idx2:
        break



print(lst[P])
print(lst[M])
print(lst[N])