import sys
from collections import deque
input = sys.stdin.readline

def solution():
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]

    def bfs(a, b):
        color = MAP[a][b]
        Q = deque()
        Q.append((a, b))

        cnt = 0
        while Q:
            x, y = Q.popleft()
            cnt += 1

            for i in range(4):
                nx = x + dx[i]
                ny = y + dy[i]
                if 0 <= nx < M and 0 <= ny < N and not visited[nx][ny] and color == MAP[nx][ny]:
                    Q.append((nx, ny))
                    visited[nx][ny] = True

        if color == "W":
            white.append(cnt*cnt)
        if color == "B":
            blue.append(cnt*cnt)

    N, M = map(int, input().split())  # [M][N]
    MAP = []
    white = []
    blue = []
    for _ in range(M):
        MAP.append(list(input().rstrip()))


    visited = [[False] * N for _ in range(M)]
    for i in range(M):
        for j in range(N):
            if not visited[i][j]:
                visited[i][j] = True
                bfs(i, j)

    print(sum(white), sum(blue))

solution()