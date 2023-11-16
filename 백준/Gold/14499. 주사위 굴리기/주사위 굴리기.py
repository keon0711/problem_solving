def roll(dir):
    temp = dice[0]

    if dir == 1:    # 동
        dice[0] = dice[3]
        dice[3] = dice[5]
        dice[5] = dice[2]
        dice[2] = temp
    elif dir == 2:  # 서
        dice[0] = dice[2]
        dice[2] = dice[5]
        dice[5] = dice[3]
        dice[3] = temp
    elif dir == 3:  # 북
        dice[0] = dice[4]
        dice[4] = dice[5]
        dice[5] = dice[1]
        dice[1] = temp
    elif dir == 4:  # 남
        dice[0] = dice[1]
        dice[1] = dice[5]
        dice[5] = dice[4]
        dice[4] = temp

    return


def check_range(next_x, next_y):
    if next_x < 0 or next_x >= N:
        return False

    if next_y < 0 or next_y >= M:
        return False

    return True



N, M, x, y, K = map(int, input().split())

dice = [0, 0, 0, 0, 0, 0]
directions = [(0, 0), (0, 1), (0, -1), (-1, 0), (1, 0)] # 동서북남

MAP = []
for _ in range(N):
    MAP.append(list(map(int, input().split())))

commands = list(map(int, input().split()))

for c in commands:
    next_x, next_y = x + directions[c][0] , y + directions[c][1]
    if not check_range(next_x, next_y):
        continue

    x, y = next_x, next_y
    roll(c);
    print(dice[0])
    if MAP[x][y] == 0:
        MAP[x][y] = dice[-1]
    else:
        dice[-1] = MAP[x][y]
        MAP[x][y] = 0
