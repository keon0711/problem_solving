N, M = map(int, input().split())
x, y, dir = list(map(int, input().split()))
MAP = [list(map(int, input().split())) for _ in range(N)]
directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]

answer = 0

while True:
    if MAP[x][y] == 0:
        answer += 1
        MAP[x][y] = '#'

    for i in range(dir - 1, dir - 5, -1):
        dx, dy = directions[i % 4]
        nx = x + dx
        ny = y + dy
        if 0 <= nx < N and 0 <= ny < M and MAP[nx][ny] == 0:
            x, y, dir = nx, ny, i % 4
            break
    else:
        dx, dy = directions[(dir + 2) % 4]
        nx = x + dx
        ny = y + dy
        if 0 <= nx < N and 0 <= ny < M and MAP[nx][ny] != 1:
            x, y = nx, ny
        else:
            break

print(answer)