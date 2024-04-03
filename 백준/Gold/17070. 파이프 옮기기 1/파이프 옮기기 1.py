def dfs(r, c, now):
    global answer

    if r<0 or r>=N or c<0 or c>=N:
        return

    if r == N-1 and c == N-1:
        answer += 1

    if now == 1:
        if 0<=c+1<N and lst[r][c+1] != 1:
            dfs(r,c+1,1)
            if 0<=r+1<N and 0<=c+1<N and lst[r][c+1] != 1 and lst[r+1][c] != 1 and lst[r+1][c+1] != 1:
                dfs(r+1,c+1,2)
    if now == 2:
        if 0<=c+1<N and lst[r][c+1] != 1:
            dfs(r,c+1,1)
        if 0<=r+1<N and lst[r+1][c] != 1:
            dfs(r+1,c,3)
        if 0<=r+1<N and 0<=c+1<N and lst[r][c+1] != 1 and lst[r+1][c] != 1 and lst[r+1][c+1] != 1:
            dfs(r+1,c+1,2)
    if now == 3:
        if 0<=r+1<N and lst[r+1][c] != 1:
            dfs(r+1,c,3)
        if 0<=r+1<N and 0<=c+1<N and lst[r][c+1] != 1 and lst[r+1][c] != 1 and lst[r+1][c+1] != 1:
            dfs(r+1,c+1,2)

N = int(input())
lst = [list(map(int, input().split())) for _ in range(N)]
answer = 0

dfs(0,1,1)  # 가로 1, 대각선2, 세로3
print(answer)