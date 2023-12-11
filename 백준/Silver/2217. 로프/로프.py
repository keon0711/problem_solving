N = int(input())
ropes = []
for _ in range(N):
    ropes.append(int(input()))
ropes.sort()

answer = 0
for i in range(N):
    W = ropes[i] * (N - i)
    answer = max(answer, W)

print(answer)