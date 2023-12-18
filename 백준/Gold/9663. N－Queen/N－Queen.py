def is_valid(depth):
    for i in range(depth):
        if board[i] == board[depth]:
            return False
        if abs(i - depth) == abs(board[i] - board[depth]):
            return False
    return True


def dfs(depth):
    global answer
    if depth == N:
        answer += 1
        return

    for i in range(N):
        board[depth] = i
        if is_valid(depth):
            dfs(depth + 1)


N = int(input())
board = [0] * N
answer = 0
dfs(0)
print(answer)