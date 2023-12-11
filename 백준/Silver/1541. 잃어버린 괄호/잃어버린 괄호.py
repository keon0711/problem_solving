exp = input()
exp = exp.split('-')

nums = []
for i in exp:
    tmp = i.split('+')
    S = sum(map(int, tmp))
    nums.append(S)

answer = nums[0]
answer -= sum(nums[1:])
print(answer)