import collections
import sys
sys.setrecursionlimit(10**5)

def dfs(v, w):
    for nv, nw in graph[v]:
        if nv not in dist:
            dist[nv] = w + nw
            dfs(nv, w + nw)


input = sys.stdin.readline
N = int(input())
graph = collections.defaultdict(list)
for _ in range(N - 1):
    A, B, W = map(int, input().split())
    graph[A].append((B, W))
    graph[B].append((A, W))

dist = collections.defaultdict(int)
dist[1] = 0
dfs(1, 0)
first_node = sorted(dist.items(), key=lambda x: x[1])[-1][0]
dist = collections.defaultdict(int)
dist[first_node] = 0
dfs(first_node, 0)
print(sorted(dist.values())[-1])