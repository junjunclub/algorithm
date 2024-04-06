T = int(input())
for _ in range(T):
    N = int(input())
    lst1 = list(map(int, input().split()))
    M = int(input())
    lst2 = list(map(int, input().split()))
    s_lst1 = set(lst1)
    for i in lst2:
        if i in s_lst1:
            print(1)
        else:
            print(0)