from collections import deque


def bfs(a, b):
    Q = deque()
    Q.append((a, b, 0))
    visited[a][b] = True
    while Q:
        x, y, dist = Q.popleft()
        MAP[x][y] = dist
        for dx, dy in ((0, 1), (0, -1), (1, 0), (-1, 0),):
            nx, ny = x + dx, y + dy
            if 0 <= nx < N and 0 <= ny < M and MAP[nx][ny] and not visited[nx][ny]:
                visited[nx][ny] = True
                Q.append((nx, ny, dist + 1))


N, M = map(int, input().split())
MAP = [list(map(int, input().split())) for _ in range(N)]
visited = [[False] * M for _ in range(N)]

flag = False
for i in range(N):
    for j in range(M):
        if MAP[i][j] == 2:
            bfs(i, j)
            flag = True
            break
    if flag:
        break

for i in range(N):
    for j in range(M):
        if not visited[i][j] and MAP[i][j] == 1:
            MAP[i][j] = -1

for x in MAP:
    print(*x)