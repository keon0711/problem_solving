def dfs(cnt):
    global answer

    if cnt == 0:
        cur_value = int("".join(nums))
        answer = max(answer, cur_value)
        return

    for i in range(length):
        for j in range(i + 1, length):
            nums[i], nums[j] = nums[j], nums[i]
            if ("".join(nums), cnt) not in visited:
                visited.add(("".join(nums), cnt))
                dfs(cnt - 1)

            nums[i], nums[j] = nums[j], nums[i]


T = int(input())
# 여러개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
for t in range(1, T + 1):
    nums, cnt = input().split()
    nums = list(nums)
    cnt = int(cnt)
    length = len(nums)

    answer = -1
    visited = set()
    dfs(cnt)

    print(f'#{t} {answer}')