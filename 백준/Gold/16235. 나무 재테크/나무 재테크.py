from copy import deepcopy
# N = 땅의 크기
# M = 나무의 갯수
# K = K년후에도 살아있는 나무의 갯수를 구해야함
N, M, K = map(int, input().split())
# 추가되는 양분의 양이 적혀있는 리스트
lst = [list(map(int, input().split())) for _ in range(N)]
# x, y 나무의 좌표, z 나무의 나이
# tree 나무의 나이가 담겨져 있는 배열
tree = [[[] for _ in range(N)] for _ in range(N)]
for _ in range(M):
    x, y, z = map(int, input().split())
    tree[x-1][y-1].append(z)

# 초기 땅의 양분
ground_lst = [[5]*N for _ in range(N)]

for _ in range(K):
    # 봄, 여름
    for i in range(N):
        for j in range(N):
            dead_idx = -1
            if tree[i][j]:
                # lst[i][j]가 있다면 graph라고 정의한다
                graph = tree[i][j]
                graph.sort()
                # 나무의 나이로 이루어진 graph를 정렬하고 순회를 시작
                for idx in range(len(graph)):
                    # 나무의 나이가 양수라면(죽은 나무가 아니면)
                    if graph[idx] > 0:
                        # 흡수할 수 있는 양분이 있다면 나무 나이 증가
                        if graph[idx] <= ground_lst[i][j]:
                            ground_lst[i][j] -= graph[idx]
                            graph[idx] += 1
                        # 흡수할 수 없다면 나무는 죽는다 (거름으로 변환)
                        else:
                            dead_idx = idx
                            break
                if dead_idx != -1:
                    tree[i][j] = tree[i][j][:dead_idx]
                    for nut in range(dead_idx, len(graph)):
                        ground_lst[i][j] += (graph[nut] // 2)

    # 가을
    for k in range(N):
        for l in range(N):
            if tree[k][l]:
                tree_graph = tree[k][l]
                for tree_age in tree_graph:
                    # 나무의 나이가 5의 배수라면
                    if tree_age % 5 == 0 and tree_age > 0:
                        for dr, dc in [(0,1),(0,-1),(1,0),(-1,0),(1,1),(1,-1),(-1,1),(-1,-1)]:
                            newR = dr+k
                            newC = dc+l
                            if 0<=newR<N and 0<=newC<N:
                                tree[newR][newC].append(1)

            ground_lst[k][l] += lst[k][l]
tree_cnt = 0
for r in range(N):
    for c in range(N):
        tree_cnt += len(tree[r][c])
print(tree_cnt)