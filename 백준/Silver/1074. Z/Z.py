def find_area(n, a, b):
    if a < 2 ** (n - 1) and b < 2 ** (n - 1):
        return 0, a, b
    if a < 2 ** (n - 1) and b >= 2 ** (n - 1):
        return 1, a, b - 2 ** (n - 1)
    if a >= 2 ** (n - 1) and b < 2 ** (n - 1):
        return 2, a - 2 ** (n - 1), b
    if a >= 2 ** (n - 1) and b >= 2 ** (n - 1):
        return 3, a - 2 ** (n - 1), b - 2 ** (n - 1)


def dfs(n, a, b):
    area, na, nb = find_area(n, a, b)
    if n == 1:
        return area

    return 2 ** (2 * (n - 1)) * area + dfs(n - 1, na, nb)


N, r, c = map(int, input().split())
print(dfs(N, r, c))