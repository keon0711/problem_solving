from itertools import permutations


def abs_diff(A):
    sum = 0
    for i in range(len(A) - 1):
        sum += abs(A[i] - A[i + 1])
    return sum

def solution():
    N = input()
    A = list(map(int, input().split()))
    answer = float('-inf')
    for p in permutations(A):
        answer = max(answer, abs_diff(p))

    print(answer)


solution()