N = int(input())
dict = {}
for _ in range(N):
    flag1 = True
    flag2 = True
    word = list(input().split())
    # 1번 조건
    for i in range(len(word)):
        st = word[i][0]
        cap_st = word[i][0].upper()
        if cap_st not in dict:
            dict[cap_st] = 1
            temp = word[i].replace(st, '['+st+']', 1)
            word[i] = temp
            print(*word)
            flag1 = False
            break
    if flag1:
        # 2번 조건
        for i in range(len(word)):
            if flag2:
                for j in range(len(word[i])):
                    st = word[i][j]
                    cap_st = word[i][j].upper()
                    if cap_st not in dict:
                        dict[cap_st] = 1
                        temp = word[i].replace(st, '['+st+']', 1)
                        word[i] = temp
                        flag2 = False
                        break
        else:
            print(*word)