N = int(input())
lst = list(map(int, input().split()))
temp = [0]
for i in range(N):
    temp.append(temp[-1]+lst[i])
# print(temp)

answer = [lst[0]]
diff = lst[0]

for i in range(1, N):
    diff += temp[i]*2 + lst[i]
    v = answer[-1]+diff
    answer.append(v)
print(*answer)