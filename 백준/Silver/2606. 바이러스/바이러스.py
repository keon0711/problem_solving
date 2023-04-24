from collections import deque

n = int(input())
graph = [[0] * (n+1) for _ in range(n+1)]
visited = [False] * (n+1)

for _ in range(int(input())):
    a, b = map(int, input().split())
    graph[a][b] = 1
    graph[b][a] = 1

ans = 0
q = deque([1])
visited[1] = True

while q:
    v = q.popleft()
    for i, c in enumerate(graph[v]):
        if visited[i] == False and c == 1:
            q.append(i)
            visited[i] = True
            ans += 1

print(ans)