import sys
input = sys.stdin.readline


def solution():
    def dfs(index, depth):
        nonlocal answer

        if depth == K - 5:
            answer = max(answer, count_words())
            return

        for i in range(index, 26):
            if visited[i]:
                continue
            visited[i] = True
            dfs(i, depth + 1)
            visited[i] = False

    def count_words():
        cnt = 0
        for word in words:
            for w in word:
                if not visited[ord(w) - ord('a')]:
                    break
            else:
                cnt += 1
        return cnt

    N, K = map(int, input().rstrip().split())
    if K < 5:
        print(0)
        return
    if K == 26:
        print(N)
        return

    north_chars = set(['a', 'n', 't', 'i', 'c'])
    words = [set(input().rstrip()) for _ in range(N)]
    visited = [False] * 26
    for c in north_chars:
        visited[ord(c) - ord('a')] = True

    for word in words:
        for c in north_chars:
            word.remove(c)


    answer = 0
    dfs(0, 0)
    print(answer)


solution()