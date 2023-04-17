import sys
from collections import deque
input = sys.stdin.readline


def solution():
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]

    def bfs(x, y):
        q = deque()
        q.append((x, y))
        graph[x][y] = 0

        cnt = 1
        while q:
            cur = q.popleft()
            for i in range(4):
                nx = cur[0] + dx[i]
                ny = cur[1] + dy[i]
                if 0 <= nx < N and 0 <= ny < N and graph[nx][ny]:
                    graph[nx][ny] = 0
                    q.append((nx, ny))
                    cnt += 1

        counts.append(cnt)




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
                bfs(i, j)
    counts.sort()
    print(groups)
    for c in counts:
        print(c)


solution()