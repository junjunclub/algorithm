N = int(input())
answer = [[0]*N for _ in range(N)]
students = [list(map(int, input().split())) for _ in range(N**2)]
for idx in range(N**2):
    student = students[idx]
    temp = []

    for i in range(N):
        for j in range(N):
            if not answer[i][j]:
                like = 0
                blank = 0
                for dr, dc in [(0,1),(0,-1),(1,0),(-1,0)]:
                    newR = i+dr
                    newC = j+dc
                    if 0<=newR<N and 0<=newC<N:
                        if not answer[newR][newC]:
                            blank += 1
                        if answer[newR][newC] in student[1:]:
                            like += 1
                temp.append([like, blank, i, j])
    temp.sort(key=lambda x:(-x[0],-x[1],x[2],x[3]))
    answer[temp[0][2]][temp[0][3]] = student[0]

satis = 0
students.sort()

for i in range(N):
    for j in range(N):
        tmp = 0
        for dr, dc in [(0,1),(0,-1),(1,0),(-1,0)]:
            newR = i+dr
            newC = j+dc
            if 0<=newR<N and 0<=newC<N and answer[newR][newC] in students[answer[i][j]-1]:
                tmp += 1
        if tmp != 0:
            satis += 10** (tmp-1)
print(satis)