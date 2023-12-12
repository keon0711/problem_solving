N = int(input())

dp = [0] * (N + 5)
dp[0] = 1
for i in range(N):
    dp[i + 1] += dp[i]
    dp[i + 2] += dp[i]

print(dp[N] % 10007)