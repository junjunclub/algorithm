N = int(input())
lst = list(map(int, input().split()))
lst.sort()
start = 0
end = N-1
answer = abs(lst[start]+lst[end])
s_idx = start
e_idx = end

while start<end:
    temp = lst[start]+lst[end]
    if abs(temp) < answer:
        answer = abs(temp)
        s_idx = start
        e_idx = end
        if answer == 0:
            break

    if temp > 0:
        end -= 1
    else:
        start += 1
print(lst[s_idx], lst[e_idx])