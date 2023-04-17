import sys
from collections import deque
input = sys.stdin.readline


def solution():
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]

    def dfs(x, y):
        cnt = 1
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0 <= nx < N and 0 <= ny < N and graph[nx][ny]:
                graph[nx][ny] = 0
                cnt += dfs(nx, ny)

        return cnt




    N = int(input())
    graph = []
    counts = []
    for _ in range(N):
        graph.append(list(map(int, input().rstrip())))

    groups = 0
    for i in range(N):
        for j in range(N):
            if graph[i][j]:
                groups += 1
                graph[i][j] = 0
                counts.append(dfs(i, j))

    counts.sort()
    print(groups)
    for c in counts:
        print(c)


solution()
