def paper(n, row, col):
    global answer
    if row == r and col == c:
        print(answer)
        return

    if not (row <= r < row + n and col <= c < col + n):
        answer += n * n
        return

    paper(n // 2, row, col)
    paper(n // 2, row, col+n//2)
    paper(n // 2, row+n//2, col)
    paper(n // 2, row+n//2, col+n//2)


N, r, c = map(int, input().split())
answer = 0
paper(2 ** N, 0, 0)