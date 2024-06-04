from collections import deque

import sys
input = sys.stdin.readline
N = int(input())
lst = list(map(int, input().split()))
left = 0
right = 0
fruit = {}
answer = 0
q = deque()
while right != len(lst):
    if len(fruit) < 2:
        fruit[lst[right]] = fruit.get(lst[right], 0) + 1
        right += 1
    elif len(fruit) == 2:
        fruit[lst[right]] = fruit.get(lst[right], 0) + 1
        if len(fruit) > 2:
            fruit[lst[left]] -= 1
            if fruit[lst[left]] == 0:
                del fruit[lst[left]]
            left += 1
        right += 1
    else:
        fruit[lst[left]] -= 1
        if fruit[lst[left]] == 0:
            del fruit[lst[left]]
        left += 1
    diff = right-left
    if answer < diff:
        answer = diff

print(answer)