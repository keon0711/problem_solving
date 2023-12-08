N, K = map(int, input().split())
coins = [int(input()) for _ in range(N)]

answer = 0
for c in reversed(coins):
    if c > K:
        continue
    answer += (K // c)
    K %= c

print(answer)