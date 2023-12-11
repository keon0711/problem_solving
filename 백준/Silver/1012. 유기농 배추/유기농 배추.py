from collections import deque


def solution():
    def bfs(x, y):
        Q = deque()
        Q.append((x, y))
        MAP[x][y] = 0
        while Q:
            cur_x, cur_y = Q.popleft()
            for dx, dy in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
                nx, ny = cur_x + dx, cur_y + dy
                if 0 <= nx < M and 0 <= ny < N and MAP[nx][ny] == 1:
                    Q.append((nx, ny))
                    MAP[nx][ny] = 0


    M, N, K = map(int, input().split())
    MAP = [[0] * N for _ in range(M)]

    for _ in range(K):
        x, y = map(int, input().split())
        MAP[x][y] = 1


    answer = 0
    for i in range(M):
        for j in range(N):
            if MAP[i][j] == 0:
                continue
            bfs(i,j)
            answer += 1

    print(answer)


for _ in range(int(input())):
    solution()
