from collections import deque
import sys


def bfs(start):
    cnt = 1
    visited = [False] * (N + 1)
    visited[start] = True
    Q = deque([start])
    while Q:
        node = Q.popleft()
        for next_node in graph[node]:
            if not visited[next_node]:
                cnt += 1
                visited[next_node] = True
                Q.append(next_node)

    return cnt


input = sys.stdin.readline

N, M = map(int, input().split())
graph = [[] for _ in range(N + 1)]

for _ in range(M):
    A, B = map(int, input().split())
    graph[B].append(A)


max_cnt = 0
answer = []
for i in range(1, N + 1):
    cnt = bfs(i)
    if max_cnt < cnt:
        answer.clear()
        answer.append(i)
        max_cnt = cnt
    elif max_cnt == cnt:
        answer.append(i)

answer.sort()
for i in answer:
    print(i, end=" ")


