import heapq

def solution(N, road, K):
    graph = [[] for _ in range(N + 1)]
    for A, B, W in road:
        graph[A].append((B, W))
        graph[B].append((A, W))

    dist = [float('inf') for _ in range(N + 1)]

    Q = []
    heapq.heappush(Q, (0, 1)) # (weight, node)
    while Q:
        weight, node = heapq.heappop(Q)
        if weight < dist[node]:
            dist[node] = weight
            for next_node, cost in graph[node]:
                heapq.heappush(Q, (weight + cost, next_node))

    return len([node for cost in dist if cost <= K])



print(solution(6, [[1,2,1],[1,3,2],[2,3,2],[3,4,3],[3,5,2],[3,5,3],[5,6,1]], 4))
