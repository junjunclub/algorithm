def find(x):
    if x != p[x]:
        p[x] = find(p[x])
    return p[x]

def union(x, y):
    x = find(x)
    y = find(y)

    if x == y:
        return

    if x < y:
        p[y] = x
    else:
        p[x] = y

N, M = map(int, input().split())
know = list(map(int, input().split()))
know_lst = know[1:]
graph = []
p = [i for i in range(N+1)]
# print(p)
for _ in range(M):
    graph.append(list(map(int, input().split()[1:])))

if not know[0]:
    print(M)
else:
    for k_person in range(1,know[0]):
        union(know_lst[k_person],know_lst[k_person-1])

    check = []
    for arr in graph:
        check.append(arr[0])
        for j in range(1,len(arr)):
            union(arr[j],arr[j-1])

    cnt = 0
    for k in check:
        if find(k) != find(know_lst[0]):
            cnt += 1
    print(cnt)