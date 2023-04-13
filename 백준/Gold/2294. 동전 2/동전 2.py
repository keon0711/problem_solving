import sys
input = sys.stdin.readline


def solution():
    n, k = map(int, input().split())
    coins = [int(input()) for _ in range(n)]
    dp = [sys.maxsize] * (k + 1)
    dp[0] = 0

    for c in coins:
        for i in range(k + 1 - c):
            dp[i + c] = min(dp[i] + 1,  dp[i + c])
    if dp[k] == sys.maxsize:
        print(-1)
    else:
        print(dp[k])

solution()