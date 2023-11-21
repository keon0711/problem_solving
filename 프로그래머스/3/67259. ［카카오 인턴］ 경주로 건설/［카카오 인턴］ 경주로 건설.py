import heapq
import sys


def solution(board):
    answer = []
    directions = [(0, 1), (1, 0), (-1, 0), (0, -1)]
    N = len(board)
    visited = [[[sys.maxsize] * 4 for _ in range(N)] for _ in range(N)]

    Q = []
    heapq.heappush(Q, (0, 0, 0, -1))
    while Q:
        cost, x, y, d = heapq.heappop(Q)
        if x == y == (N - 1):
            answer.append(cost)

        for i in range(4):
            nx = x + directions[i][0]
            ny = y + directions[i][1]
            n_cost = cost
            if d == -1 or i == d:
                n_cost += 100
            else:
                n_cost += 600
            if 0 <= nx < N and 0 <= ny < N and board[nx][ny] == 0 and n_cost < visited[nx][ny][i]:
                visited[nx][ny][i] = n_cost
                heapq.heappush(Q, (n_cost, nx, ny, i))

    return min(answer)