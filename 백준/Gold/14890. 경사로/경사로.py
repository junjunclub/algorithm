# 행 체크
def check_row(n):
    # 경사로를 놓은것을 체크하는 visited
    visited = [0]*N
    for c in range(1, N):
        # 경사로가 2이상 차이나는 경우
        if abs(lst[n][c]-lst[n][c-1]) >= 2:
            return False
        # 다음칸이 더 높은 경우
        elif lst[n][c]-lst[n][c-1] == 1:
            for g_u in range(c-L,c):
                if 0<=g_u<N and not visited[g_u]:
                    visited[g_u] = 1
                else:
                    return False
        # 다음칸이 더 낮은 경우
        elif lst[n][c]-lst[n][c-1] == -1:
            for g_d in range(c,c+L):
                if 0<=g_d<N and not visited[g_d]:
                    visited[g_d] = 1
                else:
                    return False
    return True

def check_col(n):
    # 경사로를 놓은것을 체크하는 visited
    visited = [0]*N
    for r in range(1, N):
        # 경사로가 2이상 차이나는 경우
        if abs(lst[r][n]-lst[r-1][n]) >= 2:
            return False
        # 다음칸이 더 높은 경우
        elif lst[r][n]-lst[r-1][n] == 1:
            for g_u in range(r-L,r):
                if 0<=g_u<N and not visited[g_u]:
                    visited[g_u] = 1
                else:
                    return False
        # 다음칸이 더 낮은 경우
        elif lst[r][n]-lst[r-1][n] == -1:
            for g_d in range(r,r+L):
                if 0<=g_d<N and not visited[g_d]:
                    visited[g_d] = 1
                else:
                    return False
    return True

N, L = map(int, input().split())
lst = [list(map(int, input().split())) for _ in range(N)]
answer = 0
for i in range(N):
    if check_row(i):
        answer += 1
    if check_col(i):
        answer += 1
print(answer)