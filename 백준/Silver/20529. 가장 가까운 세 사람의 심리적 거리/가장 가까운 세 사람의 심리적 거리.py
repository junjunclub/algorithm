def calc(t1, t2):
    diff = 0
    for v in range(4):
        if t1[v] != t2[v]:
            diff += 1
    return diff

def comb(n, value):
    global min_V
    if n == set_N:
        # print(path)
        temp = 0
        for j in range(len(path)-1):
            count = max(4-dict_m[set_mbti[path[j]]],0)
            for k in range(j+1,len(path)):

                for a in range(dict_m[set_mbti[path[j]]]):
                    for b in range(dict_m[set_mbti[path[k]]]):
                        if count == 0:
                            break
                        count -= 1
                        temp += (calc(set_mbti[path[j]],set_mbti[path[k]]))
        if temp < min_V:
            min_V = temp
        return

    if value >= 3:
        # print(path)
        temp = 0
        for j in range(len(path) - 1):
            count = max(4 - dict_m[set_mbti[path[j]]],0)
            for k in range(j + 1, len(path)):
                for a in range(dict_m[set_mbti[path[j]]]):
                    for b in range(dict_m[set_mbti[path[k]]]):
                        if count == 0:
                            break
                        count -= 1
                        temp += (calc(set_mbti[path[j]],set_mbti[path[k]]))
        if temp < min_V:
            min_V = temp
        return

    for i in range(n,set_N):
        if i not in path:
            path.append(i)
            comb(n+1,value+dict_m[set_mbti[i]])
            path.pop()

T = int(input())
for _ in range(T):
    N = int(input())
    dict_m = {}
    mbti = list(input().split())
    # mbti 중복 제거
    set_mbti = list(set(mbti))
    for chr in mbti:
        if chr in dict_m:
            dict_m[chr] += 1
        else:
            dict_m[chr] = 1
    set_N = len(set_mbti)
    path = []
    min_V = 10e9
    # print(set_mbti)
    comb(0,0)
    print(min_V)