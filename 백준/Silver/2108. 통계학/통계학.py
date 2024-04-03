N = int(input())
lst = []
dic = {}
for _ in range(N):
    lst.append(int(input()))
for c in lst:
    if c in dic.keys():
        dic[c] += 1
    else:
        dic[c] = 1
lst.sort()
ans1 = round(sum(lst) / N)
print(ans1)
ans2 = lst[N//2]
print(ans2)
many_v = max(dic.values())
ans_list = []
cnt = 0
for c in dic.keys():
    if dic[c] == many_v:
        ans_list.append(c)
if len(ans_list) >= 2:
    ans_list.sort()
    print(ans_list[1])
else:
    print(ans_list[0])
ans4 = max(lst) - min(lst)
print(ans4)