A, B, V = map(int, input().split()) # 낮 A 미터, 밤 B미터, V미터 도달
meter = A
day = 1
if A >= V:
    day = 1
else:
    day = (V - A) // (A - B) + 1
    if (V - A) % (A - B) > 0:
        day += 1
print(day)