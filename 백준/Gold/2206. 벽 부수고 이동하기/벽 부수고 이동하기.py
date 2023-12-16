import pprint
from collections import deque

N, M = map(int, input().split())
MAP = [list(map(int, input())) for _ in range(N)]

Q = deque()
Q. append((0, 0, 1, 1))
MAP[0][0] = 2
while Q:
    x, y, dist, breakable = Q.popleft()
    if x == N - 1 and y == M - 1:
        print(dist)
        break
    for dx, dy in ((0, 1), (1, 0), (0, -1), (-1, 0)):
        nx, ny = x + dx, y + dy
        if 0 <= nx < N and 0 <= ny < M:
            if MAP[nx][ny] == 0:
                MAP[nx][ny] = 2
                Q.append((nx, ny, dist + 1, breakable))
            if MAP[nx][ny] == 2 and breakable:
                MAP[nx][ny] = 3
                Q.append((nx, ny, dist + 1, breakable))
            if MAP[nx][ny] == 1 and breakable:
                MAP[nx][ny] = 3
                Q.append((nx, ny, dist + 1, 0))
else:
    print(-1)