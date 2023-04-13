import sys

input = sys.stdin.readline
def solution():
    n, k = map(int, input().split())
    dp = [0] * (k + 1)
    coins = [int(input()) for _ in range(n)]
    dp[0] = 1

    for c in coins:
        for i in range(k + 1 - c):
            dp[i + c] += dp[i]

    print(dp[k])


solution()