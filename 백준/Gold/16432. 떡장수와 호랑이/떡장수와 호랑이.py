def dfs(n,string):
    if answer:
        return

    if n == N:
        if string:
            answer.append(string)
            return


    for i in range(len(lst[n])):
        if n == 0:
            visited[n+1][lst[n][i]] = True
            dfs(n+1,string+str(lst[n][i]))
        else:
            if not visited[n+1][lst[n][i]]:
                a = string[-1]
                b = str(lst[n][i])
                if a != b:
                    visited[n+1][lst[n][i]] = True
                    dfs(n+1,string+str(lst[n][i]))


N = int(input())
answer = []
lst = []
visited = [[0]*10 for _ in range(N+1)]
for _ in range(N):
    m, *a = map(int, input().split())
    lst.append(a)

dfs(0,'')
if answer:
    for i in answer[0]:
        print(i)
else:
    print(-1)