T = int(input())
for _ in range(T):
    word = input()
    n = int(input())
    w_dict = {}
    for i in word:
        w_dict[i] = w_dict.get(i, 0) + 1
    # print(w_dict)

    max_v = -1
    min_v = 10e9

    answer = {}

    for j in range(len(word)):
        if w_dict[word[j]] < n:
            continue

        answer[word[j]] = answer.get(word[j], []) + [j]

    for idx, value in answer.items():
        for k in range(len(value)-n+1):
            max_v = max(max_v, value[k+n-1] - value[k] + 1)
            min_v = min(min_v, value[k+n-1] - value[k] + 1)
    if max_v == -1:
        print(-1)
    else:
        print(min_v, max_v)