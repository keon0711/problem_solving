import sys
input = sys.stdin.readline


def solution(n):
    dp = [[1] * (n + 1) for _ in range(4)]
    # 1만 사용 가능할 때 -> 무조건 1
    # for i in range(1, n + 1):
    #     dp[1][i] = 1
    # 1,2 사용 가능할 때
    for i in range(1, n + 1):
        dp[2][i] = dp[1][i]
        if i >= 2:
            dp[2][i] += dp[2][i - 2]
    for i in range(1, n + 1):
        dp[3][i] = dp[2][i]
        if i >= 3:
            dp[3][i] += dp[3][i - 3]

    print(dp[3][n])


for _ in range(int(input())):
    solution(int(input()))
