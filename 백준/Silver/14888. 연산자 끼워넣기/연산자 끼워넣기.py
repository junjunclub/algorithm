def dfs(n,sm,o1,o2,o3,o4):
    global max_V, min_V
    if n == N:
        if sm > max_V:
            max_V = sm
        if sm < min_V:
            min_V = sm
        return

    if o1:
        dfs(n+1,sm+n_lst[n],o1-1,o2,o3,o4)
    if o2:
        dfs(n+1,sm-n_lst[n],o1,o2-1,o3,o4)
    if o3:
        dfs(n+1,sm*n_lst[n],o1,o2,o3-1,o4)
    if o4:
        dfs(n+1,int(sm/n_lst[n]),o1,o2,o3,o4-1)


N = int(input())
n_lst = list(map(int, input().split()))
op_list = list(map(int, input().split()))
operation = ['+','-','*','/']
op = []
max_V = -10e9
min_V = 10e9
for i in range(len(op_list)):
    for _ in range(op_list[i]):
        op.append(operation[i])

dfs(1,n_lst[0],op_list[0],op_list[1],op_list[2],op_list[3])
print(max_V)
print(min_V)