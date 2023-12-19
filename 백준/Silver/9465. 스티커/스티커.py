def solution():
    N = int(input())
    stickers = [list(map(int, input().split())) for _ in range(2)]
    dp = [[0] * (N + 1) for _ in range(3)]
    for i in range(N):
        dp[0][i + 1] = max(dp[1][i], dp[2][i]) + stickers[0][i]
        dp[1][i + 1] = max(dp[0][i], dp[2][i]) + stickers[1][i]
        dp[2][i + 1] = max(dp[0][i], dp[1][i])

    print(max(dp[0][N], dp[1][N], dp[2][N]))


T = int(input())
for _ in range(T):
    solution()