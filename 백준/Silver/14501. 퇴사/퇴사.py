N = int(input())

schedule = [(0, 0)]
for _ in range(N):
    schedule.append(tuple(map(int, input().split())))

dp = [0] * (N + 7)

for i in range(1, N + 1):
    dp[i] = max(dp[i], dp[i - 1])
    dp[i + schedule[i][0] - 1] = max(dp[i - 1] + schedule[i][1], dp[i + schedule[i][0] - 1])


print(dp[N])

