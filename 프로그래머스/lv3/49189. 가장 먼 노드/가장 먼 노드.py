import collections
import heapq


def solution(n, edge):
    graph = [[] for _ in range(n + 1)]
    for a, b in edge:
        graph[a].append(b)
        graph[b].append(a)

    dist = collections.defaultdict(int)

    Q = []
    heapq.heappush(Q, (0, 1))
    while Q:
        cost, cur_node = heapq.heappop(Q)
        if cur_node not in dist:
            dist[cur_node] = cost
            for next_node in graph[cur_node]:
                heapq.heappush(Q, (cost + 1, next_node))

    return len([i for i in dist.values() if i == max(dist.values())])