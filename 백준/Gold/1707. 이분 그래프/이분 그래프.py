import sys
sys.setrecursionlimit(10**5)
input = sys.stdin.readline
def dfs(s, v):
    visited[s] = v

    for i in graph[s]:
        # 방문하지 않았으면
        if not visited[i]:
            temp = dfs(i,-v)
            # false가 나왔으면 return 해줘야함
            if not temp:
                return False
            # 다른 그룹이었다면
        elif visited[i] == v:
            return False
    return True

T = int(input())
for _ in range(T):
    V, E = map(int, input().split())
    graph = [[] for _ in range(V+1)]
    visited = [0]*(V+1)
    for _ in range(E):
        s, e = map(int, input().split())
        graph[s].append(e)
        graph[e].append(s)
    flag = True
    for i in range(1, V+1):
        if not visited[i]:
            flag = dfs(i, 1)
            if not flag:
                print("NO")
                break
    else:
        print("YES")