n = int(input())
promise = {}
money = {}
result = 0

day = [0]*70

for _ in range(n):
    lst = list(input().split())
    promise[lst[0]] = [(int(lst[1])-1)*7 + int(lst[2]), int(lst[3])]

# print(promise)
for _ in range(n):
    lst = list(input().split())
    money[lst[0]] = int(lst[1])
# print(money)

for i in money:
    if money[i] >= promise[i][1]:
        day[promise[i][0]] = True

result = 0
temp = 0
for i in day:
    if i:
        temp += 1
    else:
        result = max(temp, result)
        temp = 0
result = max(temp, result)
print(result)
