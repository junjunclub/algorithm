def dfs(v, s):
    visited[v] = True
    value = lst[v]

    if not visited[value]:
        dfs(value, s)
    elif visited[v] and value == s:
        answer.append(value)

N = int(input())
lst = [0]
answer = []
for _ in range(N):
    lst.append(int(input()))

# print(lst)

for i in range(1,N+1):
    visited = [False]*(N+1)
    dfs(i,i)

print(len(answer))
for ans in answer:
    print(ans)