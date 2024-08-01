N = int(input())
nums = [float(input()) for _ in range(N)]
for i in range(1, N):
    nums[i] = max(nums[i - 1] * nums[i], nums[i])
print("{:.3f}".format(max(nums)))