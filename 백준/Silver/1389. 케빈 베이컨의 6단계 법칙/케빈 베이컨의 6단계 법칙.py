import sys

INF = sys.maxsize
N, M = map(int, input().split())
kevin_bacon = [[INF] * (N) for _ in range(N)]
for i in range(N):
    kevin_bacon[i][i] = 0

for _ in range(M):
    A, B = map(int, input().split())
    kevin_bacon[A - 1][B - 1] = 1
    kevin_bacon[B - 1][A - 1] = 1

for k in range(N):
    for i in range(N):
        for j in range(N):
            kevin_bacon[i][j] = min(kevin_bacon[i][j], kevin_bacon[i][k] + kevin_bacon[k][j])

answer = [sum(kevin_bacon[i]) for i in range(N)]
for i in range(N):
    if answer[i] == min(answer):
        print(i + 1)
        break

