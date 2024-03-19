def paper(r,c,l):
    global blue, white
    color = lst[r][c]
    for i in range(r,r+l):
        for j in range(c,c+l):
            if lst[i][j] != color:
                paper(r,c,l//2)
                paper(r+l//2,c,l//2)
                paper(r,c+l//2,l//2)
                paper(r+l//2,c+l//2,l//2)
                return
    if color:
        blue += 1
    else:
        white += 1

N = int(input())
lst = [list(map(int, input().split())) for _ in range(N)]
blue = 0
white = 0
paper(0,0,N)
print(white)
print(blue)