def check():
    max_cnt = 0
    for i in range(N):
        row_cnt = 1
        col_cnt = 1
        for j in range(1, N):
            if candies[i][j] == candies[i][j - 1]:
                row_cnt += 1
                max_cnt = max(max_cnt, row_cnt)
            else:
                row_cnt = 1

            if candies[j][i] == candies[j - 1][i]:
                col_cnt += 1
                max_cnt = max(max_cnt, col_cnt)
            else:
                col_cnt = 1

    return max_cnt


N = int(input())
candies = [list(input()) for _ in range(N)]
ans = 0

for i in range(N):
    for j in range(N - 1):
        candies[i][j], candies[i][j + 1] = candies[i][j + 1], candies[i][j]  #좌우 스왑
        ans = max(ans, check())
        candies[i][j], candies[i][j + 1] = candies[i][j + 1], candies[i][j]  # 원상복귀

        candies[j][i], candies[j + 1][i] = candies[j + 1][i], candies[j][i]
        ans = max(ans, check())
        candies[j][i], candies[j + 1][i] = candies[j + 1][i], candies[j][i]

print(ans)