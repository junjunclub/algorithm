n = int(input())
lst = list(map(int, input().split()))

num = 1
ans = []
for i in lst:
    ans.append(i)

    while ans and ans[-1] == num:
        ans.pop()
        num += 1

if ans:
    print('Sad')
else:
    print('Nice')

