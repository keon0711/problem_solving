import sys
from itertools import combinations

N = int(input())
S = [list(map(int, input().split())) for _ in range(N)]


def calc_score(members):
    score = 0
    for i in members:
        for j in members:
            score += S[i][j]

    return score


def calc_gap(A, B):
    return abs(calc_score(A) - calc_score(B))


teams = list(combinations(range(N), N // 2))
result = sys.maxsize
for A in teams:
    B = [i for i in range(N) if i not in A]
    gap = calc_gap(A, B)
    result = min(result, gap)

print(result)