def dfs(arr, v):    # dfs
    ST = []
    d_visited = [0] * (N + 1)
    ST.append(v)
    d_visited[v] = 1

    while ST:
        S_value = ST.pop()

        for value in graph[S_value]:
            if not d_visited[value] and value in arr:
                d_visited[value] = 1
                ST.append(value)
    if sum(d_visited) == len(arr):
        return True

def subSum(n):
    global min_V
    if n == N:
        if sum(result) == 0 or sum(result) == N:
            return
        first_group = []
        second_group = []
        for i in range(N):
            if result[i] == 0:
                second_group.append(i+1)
            elif result[i] == 1:
                first_group.append(i+1)
        # print(f'f는 {first_group}')
        # print(f's는 {second_group}')
        first_value = 0
        if dfs(first_group, first_group[0]) and dfs(second_group,second_group[0]):
            for s in range(N):
                if result[s]:
                    first_value += lst[s]
            # print(f'f값은 {first_value}')
            second_value = sum_V - first_value
            # print(f's값은 {second_value}')
            if min_V > abs(first_value-second_value):
                min_V = abs(first_value-second_value)
        return


    result[n] = 1
    subSum(n+1)
    result[n] = 0
    subSum(n+1)

N = int(input())
lst = list(map(int, input().split()))
graph = [[] for _ in range(N + 1)]

result = [0] * (N)
min_V = 10e9
sum_V = sum(lst)    # 모든 인구 수

for i in range(1, N + 1):   # 그래프 연결
    num, *connect = map(int, input().split())
    for j in range(len(connect)):
        graph[i].append(connect[j])


subSum(0)
if min_V == 10e9:
    print(-1)
else:
    print(min_V)