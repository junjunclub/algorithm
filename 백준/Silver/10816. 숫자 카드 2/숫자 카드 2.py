from collections import defaultdict, Counter

N = int(input()) # 카드 수

cards = list(map(int, input().split())) # 카드 값

M = int(input()) # 몇 개 가지고 있는 지 구할 숫자 카드 M 개

number_to_find = list(map(int, input().split()))

dic = defaultdict(int)

for card in cards:
    dic[card] += 1

for c in number_to_find:
    print(dic[c], end = " ")
