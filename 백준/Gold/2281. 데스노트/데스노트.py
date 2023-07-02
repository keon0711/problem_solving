import sys

def solution():
    N, M = map(int, input().split())
    names = [int(input()) for _ in range(N)]
    memo = [[sys.maxsize] * (M+1) for _ in range(N)]
    memo[0][M - names[0]] = 0

    for i in range(1, N):
        name = names[i]
        for j in range(M + 1):
            if memo[i - 1][j] != sys.maxsize:
                # 남는 공간이 있을 때 -> 제곱합 변동 없음
                if j > name:
                    memo[i][j - (name + 1)] = min(memo[i][j - (name + 1)], memo[i - 1][j])
                # 새 줄에 넣을 때
                memo[i][M - name] = min(memo[i - 1][j] + (j ** 2), memo[i][M - name])

    print(min(memo[N-1]))




solution()
