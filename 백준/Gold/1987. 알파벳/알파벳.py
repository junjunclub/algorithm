def dfs(r, c, cnt):
    global max_V

    max_V = max(cnt, max_V)

    for dr, dc in [(0,1),(0,-1),(1,0),(-1,0)]:
        newR = dr+r
        newC = dc+c

        if 0<=newR<R and 0<=newC<C and not visited[ord(lst[newR][newC])-65]:
            visited[ord(lst[newR][newC])-65] = 1
            dfs(newR,newC, cnt + 1)
            visited[ord(lst[newR][newC])-65] = 0

R, C = map(int, input().split())
lst = [list(input()) for _ in range(R)]
max_V = 1
visited = [0]*26
visited[ord(lst[0][0])-65] = 1
# print(visited)
# print(ord(lst[0][0])-65)

dfs(0,0,1)
print(max_V)