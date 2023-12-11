N = int(input())
road = list(map(int, input().split()))
city = list(map(int, input().split()))

min_cost = city[0]
answer = 0
for i in range(N - 1):
    min_cost = min(min_cost, city[i])
    answer += road[i] * min_cost

print(answer)