def dfs(result, depth):
    if depth == N:
        results.append(result)
        return

    for i in range(4):
        if ops[i] > 0:
            ops[i] -= 1
            if i == 0:
                dfs(result + nums[depth], depth + 1)
            if i == 1:
                dfs(result - nums[depth], depth + 1)
            if i == 2:
                dfs(result * nums[depth], depth + 1)
            if i == 3:
                dfs(int(result / nums[depth]), depth + 1)
            ops[i] += 1

N = int(input())
nums = list(map(int, input().split()))
ops = list(map(int, input().split()))
results = []
dfs(nums[0], 1)
print(max(results))
print(min(results))
