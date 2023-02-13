def solution(nums):
    N = len(nums)
    nums = set(nums)
    if len(nums) >= N / 2:
        return N / 2
        
    return len(nums)
