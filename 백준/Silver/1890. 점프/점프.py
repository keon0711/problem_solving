import sys

input = sys.stdin.readline


def solution():
    def dfs(x, y):
        if x == N - 1 and y == N - 1:
            return 1

        # 이미 방문했으면 route를 참조
        if route[x][y] != -1:
            return route[x][y]

        # 방문하지 않았으면 탐색
        jump = MAP[x][y]
        route[x][y] = 0
        if x + jump < N and y < N:
            route[x][y] += dfs(x + jump, y)

        if x < N and y + jump < N:
            route[x][y] += dfs(x, y + jump)

        return route[x][y]


    N = int(input())
    MAP = [list(map(int, input().split())) for _ in range(N)]
    route = [[-1] * N for _ in range(N)]
    dfs(0, 0)
    print(route[0][0])


solution()
