import sys
from collections import deque
sys.setrecursionlimit(10000000)

def solution():
    def dfs(x, y, dist):
        MAP[x][y] = dist

        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < M and (MAP[nx][ny] == 0 or dist + 1 < MAP[nx][ny]):
                dfs(nx, ny, dist + 1)

    dx = [1, 1, 1, -1, -1, -1, 0, 0]
    dy = [-1, 0, 1, -1, 0, 1, -1, 1]

    N, M = map(int, input().split())
    MAP = [list(map(int, input().split())) for _ in range(N)]

    for i in range(N):
        for j in range(M):
            if MAP[i][j] == 1:
                dfs(i, j, 1)

    print(max(map(max, MAP)) - 1)



solution()