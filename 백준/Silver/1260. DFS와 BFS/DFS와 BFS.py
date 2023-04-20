import sys
from collections import deque
input = sys.stdin.readline

def solution():
    def dfs(cur_node):
        if visited[cur_node]:
            return
        print(cur_node, end=' ')
        visited[cur_node] = True

        for i in range(1, N + 1):
            if graph[cur_node][i] == 1:
                dfs(i)



    def bfs(start):
        Q = deque()
        Q.append(start)
        visited[start] = True
        while Q:
            cur_node = Q.popleft()
            print(cur_node, end=' ')
            for i in range(1, N + 1):
                if graph[cur_node][i] == 1 and visited[i] == False:
                    Q.append(i)
                    visited[i] = True


    N, M, V = map(int, input().split())
    graph = [[0] * (N + 1) for _ in range(N + 1)]
    visited = [False] * (N + 1)
    for _ in range(M):
        A, B = map(int, input().split())
        graph[A][B] = 1
        graph[B][A] = 1

    dfs(V)
    visited = [False] * (N + 1)
    print()
    bfs(V)


solution()