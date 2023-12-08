N = int(input())
nums = list(map(int, input().split()))
S = int(input())

for i in range(N):
    if S == 0:
        break
    max_num_in_range = max(nums[i: i + S + 1])
    j = nums.index(max_num_in_range)
    S -= abs(j - i)
    for k in range(j, i, -1):
        nums[k], nums[k - 1] = nums[k - 1], nums[k]


[print(x, end=' ') for x in nums]