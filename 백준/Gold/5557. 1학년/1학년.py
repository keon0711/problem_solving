def solution():
    N = int(input())
    *nums, ans = map(int, input().split())
    memo = [[0] * 21 for _ in range(N - 1)]
    memo[0][nums[0]] = 1

    for i in range(1, N - 1):
        for j in range(21):
            if j + nums[i] <= 20:
                memo[i][j + nums[i]] += memo[i - 1][j]
            if 0 <= j - nums[i]:
                memo[i][j - nums[i]] += memo[i - 1][j]

    print(memo[N - 2][ans])


solution()
