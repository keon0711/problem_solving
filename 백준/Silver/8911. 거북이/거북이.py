import sys
input = sys.stdin.readline


def solution(COMMANDS):
    def update_move_range():
        move_range[0] = min(turtle[0], move_range[0])   # TOP
        move_range[1] = max(turtle[0], move_range[1])   # DOWN
        move_range[2] = min(turtle[1], move_range[2])   # LEFT
        move_range[3] = max(turtle[1], move_range[3])   # RIGHT


    def move_turtle(order):
        x, y = dir[turtle[2]]

        if order == 'L':
            turtle[2] = (turtle[2] - 1) % 4
        elif order == 'R':
            turtle[2] = (turtle[2] + 1) % 4
        elif order == 'F':
            turtle[0] += x
            turtle[1] += y
            update_move_range()
        elif order == 'B':
            turtle[0] -= x
            turtle[1] -= y
            update_move_range()


    dir = [(-1, 0), (0, 1), (1, 0), (0, -1)]
    # top, right, down, left
    move_range = [0] * 4

    turtle = [0, 0, 0]
    for c in COMMANDS:
        move_turtle(c)
        update_move_range()

    print((move_range[1] - move_range[0]) * (move_range[3] - move_range[2]))


n = int(input().rstrip())
for _ in range(n):
    solution(input().rstrip())