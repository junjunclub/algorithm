def valid_check(now, next):
    if abs(ord(now[0])-ord(next[0])) == 2 and abs(ord(now[1])-ord(next[1])) == 1:
        return True
    elif abs(ord(now[0])-ord(next[0])) == 1 and abs(ord(now[1])-ord(next[1])) == 2:
        return True
    else:
        return False

knight = []
now = input()
knight.append(now)
cnt = 1
for i in range(35):
    next = input()
    knight.append(next)

    if valid_check(now, next):
        cnt += 1
        now = next
    else:
        break

if cnt == 36 and len(set(knight)) == 36 and valid_check(knight[0], knight[-1]):
    print('Valid')
else:
    print('Invalid')