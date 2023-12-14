import heapq

N, M, X = map(int, input().split())
INF = int(1e9)
MAP = [[INF] * (N + 1) for _ in range(N + 1)]
for _ in range(M):
    A, B, T = map(int, input().split())
    MAP[A][B] = T

to_come = [-1] * (N + 1)
for i in range(1, N + 1):
    dist = [INF] * (N + 1)
    Q = []
    heapq.heappush(Q, (0, i))
    while Q:
        c, v = heapq.heappop(Q)
        if v == X:
            to_come[i] = c
            break
        for nv in range(1, N + 1):
            nc = MAP[v][nv]
            if dist[nv] > c + nc:
                heapq.heappush(Q, (c + nc, nv))
                dist[nv] = c + nc


to_go = [INF] * (N + 1)
to_go[X] = 0
Q = []
heapq.heappush(Q, (0, X))
while Q:
    c, v = heapq.heappop(Q)
    for nv in range(1, N + 1):
        nc = MAP[v][nv]
        if to_go[nv] > c + nc:
            heapq.heappush(Q, (c + nc, nv))
            to_go[nv] = c + nc
answer = 0
for i in range(1, N + 1):
    answer = max(answer, to_go[i] + to_come[i])


print(answer)