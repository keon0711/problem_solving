import sys

def move_clouds(d, s):
    for cloud in clouds:
        nx = (cloud[0] + directions[d][0] * s) % N
        ny = (cloud[1] + directions[d][1] * s) % N
        cloud[0] = nx
        cloud[1] = ny
        visited[nx][ny] = True


def rain_and_duplicate(): # 4 * len*clouds
    for x, y in clouds:
        MAP[x][y] += 1

    for x, y in clouds:
        adjacent_basket = 0
        for nx, ny in ((x - 1, y - 1), (x - 1, y + 1), (x + 1, y - 1), (x + 1, y + 1)):
            if 0 <= nx < N and 0 <= ny < N and MAP[nx][ny] > 0:
                adjacent_basket += 1
        MAP[x][y] += adjacent_basket


def create_cloud(): # N^2
    new_clouds = []

    for i in range(N):
        for j in range(N):
            if MAP[i][j] >= 2 and not visited[i][j]:
                new_clouds.append([i, j])
                MAP[i][j] -= 2

    return new_clouds


N, M = map(int, sys.stdin.readline().split())
MAP = [list(map(int, sys.stdin.readline().split())) for _ in range(N)]
directions = [0, (0, -1), (-1, -1), (-1, 0), (-1, 1), (0, 1), (1, 1), (1, 0), (1, -1)]
clouds = [[N - 2, 0], [N - 1, 0], [N - 2, 1], [N - 1, 1]]

for _ in range(M):
    visited = [[False] * N for _ in range(N)]
    d, s = map(int, sys.stdin.readline().split())
    move_clouds(d, s)
    rain_and_duplicate()
    clouds = create_cloud()

print(sum(map(sum, MAP)))
