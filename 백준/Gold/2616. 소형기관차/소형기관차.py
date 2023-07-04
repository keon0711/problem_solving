

def solution():
    N = int(input())
    people = list(map(int, input().split()))
    M = int(input())
    dp = [[0] * (N + 1) for _ in range(4)]

    S = [0]
    for p in people:
        S.append(S[-1] + p)

    for i in range(1, 4):
        for j in range(M, N + 1):
            dp[i][j] = max(dp[i][j - 1], S[j] - S[j - M] + dp[i - 1][j - M])

    print(dp[3][N])


solution()