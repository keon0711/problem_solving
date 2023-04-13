import sys
from collections import deque

input = sys.stdin.readline
def solution():
    N, M = map(int, input().split())
    graph = [[] for _ in range(N + 1)]
    in_degree = [0] * (N+1)

    for _ in range(M):
        A, B = map(int, input().split())
        graph[A].append(B)
        in_degree[B] += 1

    Q = deque()
    for i in range(1, N + 1):
        if in_degree[i] == 0:
            Q.append(i)

    result = []
    while Q:
        cur = Q.popleft()
        result.append(cur)
        for next in graph[cur]:
            in_degree[next] -= 1
            if in_degree[next] == 0:
                Q.append(next)
    print(*result)

solution()