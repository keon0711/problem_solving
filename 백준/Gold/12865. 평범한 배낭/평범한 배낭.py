from itertools import permutations
from collections import deque


def solution():
    N, K = map(int, input().split())
    memo = [[0] * (K + 1) for _ in range(N + 1)]

    for i in range(1, N + 1):
        W, V = map(int, input().split())
        for j in range(1, K + 1):
            if W > j:
                memo[i][j] = memo[i - 1][j]
            else:
                memo[i][j] = max(memo[i - 1][j], V + memo[i - 1][j - W])

    print(memo[N][K])


solution()