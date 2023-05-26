import sys
import heapq
input = sys.stdin.readline


def solution():
    def find(x):
        if root[x] == x:
            return x

        root[x] = find(root[x])
        return root[x]

    def union(x, y):
        root[find(y)] = find(x)

    N = int(input())
    M = int(input())
    root = [i for i in range(N + 1)]
    heap = []
    for _ in range(M):
        a, b, c = map(int, input().split())
        heapq.heappush(heap, (c, a, b))

    answer = 0
    for _ in range(M):
        c, a, b = heapq.heappop(heap)
        if find(a) == find(b):
            continue
        answer += c
        union(a, b)

    print(answer)

solution()