from collections import deque


N = int(input())
K = int(input())

apples = []
for k in range(K):
    x, y = map(int, input().split())
    apples.append((x, y))

L = int(input())
movements = []
for l in range(L):
    X, C = input().split()
    X = int(X)
    movements.append((X, C))
movements.reverse()

time = 0

directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
snake = deque([(1, 1)])
cur_dir = 0

while True:
    time += 1

    next_head = (snake[-1][0] + directions[cur_dir][0], snake[-1][1] + directions[cur_dir][1])

    if next_head[0] == 0 or next_head[0] == N + 1 or next_head[1] == 0 or next_head[1] == N + 1 or next_head in snake:
        print(time)
        break

    snake.append(next_head)

    if next_head in apples:
        apples.remove(next_head)
    else:
        snake.popleft()

    if movements and movements[-1][0] == time:
        X, C = movements.pop()
        if C == 'L':
            cur_dir = (cur_dir - 1) % 4
        if C == 'D':
            cur_dir = (cur_dir + 1) % 4