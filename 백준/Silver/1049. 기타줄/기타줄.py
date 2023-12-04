N, M = map(int, input().split())

package = []
single = []
for _ in range(M):
    a, b = map(int, input().split())
    package.append(a)
    single.append(b)

min_package = min(package)
min_single = min(single)

cost = 0
cost += (N // 6) * min(min_single * 6, min_package)
cost += min((N % 6) * min_single, min_package)

print(cost)
