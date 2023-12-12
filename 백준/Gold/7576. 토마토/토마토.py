from collections import deque


def solution():
    M, N = map(int, input().split())
    tomato = [list(map(int, input().split())) for _ in range(N)]

    Q = deque()
    for i in range(N):
        for j in range(M):
            if tomato[i][j] == 1:
                Q.append((i, j, 1))

    while Q:
        x, y, days = Q.popleft()
        for dx, dy in ((0, 1), (0, -1), (1, 0), (-1, 0)):
            nx, ny = x + dx, y + dy
            if 0 <= nx < N and 0 <= ny < M and tomato[nx][ny] == 0:
                tomato[nx][ny] = days + 1
                Q.append((nx, ny, days + 1))

    days_taken = 0
    for i in range(N):
        for j in range(M):
            if tomato[i][j] == 0:
                return -1
            days_taken = max(days_taken, tomato[i][j] - 1)
    return days_taken


print(solution())
