from collections import deque


N, M = map(int, input().split())
MAP = [list(map(int, input().split())) for _ in range(N)]
visited = [[-1] * M for _ in range(N)]

Q = deque()

for i in range(N):
    for j in range(M):
        if MAP[i][j] == 2:
            visited[i][j] = 0
            Q.append((i, j))
        elif MAP[i][j] == 0:
            visited[i][j] = 0

while Q:
    x, y = Q.popleft()
    for nx, ny in ((x, y + 1), (x, y - 1), (x + 1, y), (x - 1, y)):
        if 0 <= nx < N and 0 <= ny < M and visited[nx][ny] == -1:
            visited[nx][ny] = visited[x][y] + 1
            Q.append((nx, ny))

for row in visited:
    print(*row)