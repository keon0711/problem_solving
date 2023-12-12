def is_one_color(n, x, y):
    for i in range(n):
        for j in range(n):
            if paper[x + i][y + j] != paper[x][y]:
                return False
    return True


def dfs(n, x, y):
    global white, blue
    half = n // 2
    if is_one_color(n, x, y):
        if paper[x][y] == 0:
            white += 1
        else:
            blue += 1
    else:
        dfs(half, x, y)
        dfs(half, x + half, y)
        dfs(half, x , y + half)
        dfs(half, x + half, y + half)



N = int(input())
paper = [list(map(int, input().split())) for _ in range(N)]
white = 0
blue = 0
dfs(N, 0, 0)
print(white)
print(blue)