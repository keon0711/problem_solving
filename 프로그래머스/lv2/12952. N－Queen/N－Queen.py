def solution(n):
    queens = []

    def check(depth, col):
        for d in range(len(queens)):
            if (d - queens[d]) == (depth - col) or (d + queens[d]) == (depth + col):
                return False

        return True

    def dfs(depth):
        cnt = 0
        if depth == n:
            return 1

        for i in range(n):
            if i not in queens and check(depth, i):
                queens.append(i)
                cnt += dfs(depth + 1)
                queens.pop()
        return cnt

    return dfs(0)