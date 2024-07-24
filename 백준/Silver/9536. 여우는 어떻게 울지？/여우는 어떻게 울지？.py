T = int(input())
lst = []
for _ in range(T):
    lst = list(input().split())
    animal = {}
    while True:
        temp = list(input().split(' goes '))
        if temp[0] == 'fox':
            continue
        if temp[0] == 'what does the fox say?':
            break

        animal[temp[0]] = temp[1]

    answer = []
    for j in range(len(lst)):
        if lst[j] not in animal.values():
            answer.append(lst[j])
    print(' '.join(answer))
