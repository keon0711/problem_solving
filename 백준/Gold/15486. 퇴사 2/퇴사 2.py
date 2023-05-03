def solution():
    N = int(input())
    days = [(0, 0)]
    [days.append(tuple(map(int, input().split()))) for _ in range(N)]
    max_profit = [0] * (N + 51)

    for i in range(1, N + 1):
        max_profit[i] = max(max_profit[i], max_profit[i -1])
        max_profit[i + days[i][0]] = max(max_profit[i + days[i][0]], days[i][1] + max_profit[i])




    print(max(max_profit[N + 1], max_profit[N]))


solution()