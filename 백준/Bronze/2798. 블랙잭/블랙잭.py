def find_closest_sum(cards, N, M, start, depth, current_sum):
    global max_sum

    if depth == 3:
        if current_sum <= M:
            max_sum = max(max_sum, current_sum)
        return

    if start >= N:
        return

    find_closest_sum(cards, N, M, start + 1, depth + 1, current_sum + cards[start])
    find_closest_sum(cards, N, M, start + 1, depth, current_sum)


N, M = map(int, input().split())

cards = list(map(int, input().split()))

max_sum = 0
find_closest_sum(cards, N, M, 0, 0, 0)

print(max_sum)