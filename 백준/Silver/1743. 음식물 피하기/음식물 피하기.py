import sys
sys.setrecursionlimit(100000)


input = sys.stdin.readline


def solution():
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, - 1]

    def dfs(x, y):
        MAP[x][y] = 0

        food_size = 1
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 1 <= nx <= N and 1 <= ny <= M and MAP[nx][ny] == 1:
                food_size += dfs(nx, ny)
        return food_size

    N, M, K = map(int, input().split())
    MAP = [[0] * (M + 1) for _ in range(N + 1)]
    for _ in range(K):
        A, B = map(int, input().split())
        MAP[A][B] = 1

    max_food = 0
    for i in range(1, N + 1):
        for j in range(1, M + 1):
            if MAP[i][j] == 1:
                max_food = max(max_food, dfs(i, j))
    print(max_food)


solution()
