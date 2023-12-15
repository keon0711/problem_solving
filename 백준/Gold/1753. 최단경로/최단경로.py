import heapq
import sys

INF = sys.maxsize
input = sys.stdin.readline
V, E = map(int, input().split())
K = int(input())
graph = [[] for _ in range(V + 1)]
for _ in range(E):
    u, v, w = map(int, input().split())
    graph[u].append((v, w))

Q = []
dist = [INF] * (V + 1)
heapq.heappush(Q, (0, K))
dist[K] = 0
while Q:
    cost, node = heapq.heappop(Q)
    if dist[node] < cost:
        continue
    for v, w in graph[node]:
        alt = cost + w
        if dist[v] > alt:
            heapq.heappush(Q, (alt, v))
            dist[v] = alt

for i in range(1, V + 1):
    print(dist[i] if dist[i] != INF else "INF")