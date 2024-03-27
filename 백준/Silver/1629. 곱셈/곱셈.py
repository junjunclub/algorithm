import sys
input = sys.stdin.readline

def multiple(x, y):
    global C
    if y == 1:
        return x

    if y % 2 == 0:
        res = multiple(x, y/2)
        return res*res%C
    else:
        res = multiple(x, (y-1)/2)
        return res*res*x%C


A, B, C = map(int, input().split())

answer = multiple(A, B)
print(answer%C)
