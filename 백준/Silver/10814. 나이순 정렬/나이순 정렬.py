T = int(input())

members_input = [input() for _ in range(T)]

members = [(int(age), name) for age, name in (member.split() for member in members_input)]

members_sorted = sorted(members, key=lambda x: x[0])

for i in range(len(members_sorted)):
    print(f'{members_sorted[i][0]} {members_sorted[i][1]}')