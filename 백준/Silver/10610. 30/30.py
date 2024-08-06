n = input()
temp = 0
for i in n:
    temp += int(i)

if not temp % 3 and '0' in n:
    print(''.join(sorted(n, key=lambda x:-int(x))))
else:
    print(-1)