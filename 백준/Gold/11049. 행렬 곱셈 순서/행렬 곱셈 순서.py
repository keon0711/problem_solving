import sys

MAX = sys.maxsize
N = int(input())
matrix = []
for _ in range(N):
    matrix.append(list(map(int, input().split())))
dp = [[MAX for _ in range(N)] for _ in range(N)]

for k in range(N):
    dp[k][k] = 0

for k in range(1, N):
    for i in range(N - k):
        for j in range(i, i + k):
            dp[i][i + k] = min(dp[i][i + k], dp[i][j] + dp[j + 1][i + k] + matrix[i][0]*matrix[j][1]*matrix[i + k][1])

print(dp[0][N - 1])