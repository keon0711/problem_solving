import sys
input = sys.stdin.readline


def solution():
    answer = []

    def dfs(num, index):
        if index > 10:
            return

        answer.append(num)
        for i in [x for x in range(10) if x < num % 10]:
            next_num = num * 10 + i
            dfs(next_num, index + 1)

    N = int(input())
    for i in range(10):
        dfs(i, 0)
    answer.sort()
    print(answer[N] if N < len(answer) else -1)



solution()
