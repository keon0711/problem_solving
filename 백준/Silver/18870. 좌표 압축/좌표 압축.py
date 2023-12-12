N = int(input())
X = list(map(int, input().split()))
sorted_X = sorted(set(X))
DICT = {}

for i in range(len(sorted_X)):
    DICT[sorted_X[i]] = i

print(*map(lambda x: DICT[x], X))