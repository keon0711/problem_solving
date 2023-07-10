from itertools import permutations

def solution():
    MAX = 100
    N = int(input())
    HP = list(map(int, input().split()))
    attacks = list(permutations([9, 3, 1]))
    memo = [[[MAX] * 61 for _ in range(61)] for _ in range(61)]
    memo[0][0][0] = 0

    def dfs(HP):
        for i in range(3):
            HP[i] = max(HP[i], 0)

        HP.sort()
        i, j, k = HP
        if memo[i][j][k] != MAX:
            return memo[i][j][k]


        for a, b, c in attacks:
            memo[i][j][k] = min(dfs([i - a, j - b, k - c]) + 1, memo[i][j][k])

        return memo[i][j][k]

    for _ in range(3 - N):
        HP.append(0)

    print(dfs(HP))


solution()