import heapq
import sys


input = sys.stdin.readline

def solution():
    N = int(input())
    M = int(input())
    dist = [float('inf')] * (N + 1)
    graph = [[] for _ in range(N + 1)]
    heap = []

    for i in range(M):
        A, B, C = map(int, input().split())
        graph[A].append((C, B))

    start, end = map(int, input().split())
    heapq.heappush(heap, (0, start))
    while heap:
        cost, cur_node = heapq.heappop(heap)
        if cost < dist[cur_node]:
            dist[cur_node] = cost
            for next_cost, next_node in graph[cur_node]:
                heapq.heappush(heap, (cost + next_cost, next_node))

    print(dist[end])


solution()

