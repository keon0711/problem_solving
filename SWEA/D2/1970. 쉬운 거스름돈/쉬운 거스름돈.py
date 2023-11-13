T = int(input())
coins = [50000, 10000, 5000, 1000, 500, 100, 50, 10]

for t in range(T):
    result = []
    amount = int(input())

    for coin in coins:
        result.append(amount // coin)
        amount %= coin

    print(f'#{t + 1}')
    print(*result)