from collections import deque


def rotate(num, dir):
    if num < 3 and gears[num][2] != gears[num + 1][6] and not visited[num + 1]:
        visited[num + 1] = True
        rotate(num + 1, dir * -1)

    if num > 0 and gears[num][6] != gears[num - 1][2] and not visited[num - 1]:
        visited[num - 1] = True
        rotate(num - 1, dir * -1)

    # 회전
    if dir == 1:
        gears[num].appendleft(gears[num].pop())
    else:
        gears[num].append(gears[num].popleft())


gears = [deque(map(int, list(input()))) for _ in range(4)]
K = int(input())

for _ in range(K):
    num, dir = map(int, input().split())
    num -= 1
    visited = [False] * 4
    visited[num] = True
    rotate(num, dir)


score = 0
for i in range(4):
    if gears[i][0] == 1:
        score += 2 ** i


print(score)