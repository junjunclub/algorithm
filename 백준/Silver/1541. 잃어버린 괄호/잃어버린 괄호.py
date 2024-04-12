num = input().split('-')
lst = []
result = 0
for i in num[0].split('+'):
    result += int(i)

for j in num[1:]:
    for k in j.split('+'):
        result -= int(k)
print(result)
