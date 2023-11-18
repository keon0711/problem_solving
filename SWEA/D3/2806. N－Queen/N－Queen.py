def is_valid(x):
    for i in range(x):
        if row[x] == row[i] or abs(x - i) == abs(row[x] - row[i]):
            return False

    return True


def dfs(x):
    global answer
    if x == N:
        answer += 1
        return

    for y in range(N):
        row[x] = y
        if is_valid(x):
            dfs(x + 1)


T = int(input())

for t in range(T):
    N = int(input())
    answer = 0
    row = [0] * N
    dfs(0)
    print(f'#{t+1} {answer}')
