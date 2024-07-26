word = input()
ans1 = word.split('0')
ans2 = word.split('1')

a = len(ans1) - ans1.count('')
b = len(ans2) - ans2.count('')
print(min(a, b))