import heapq
import sys


input = sys.stdin.readline

def solution():

    def union(x, y):
        x = find(x)
        y = find(y)

        root[y] = x

    def find(x: int) -> int:
        if root[x] == x:
            return x
        root[x] = find(root[x])
        return root[x]


    V, E = map(int, input().split())
    root = [i for i in range(V + 1)]
    heap = []
    for i in range(E):
        A, B, C = map(int, input().split())
        heapq.heappush(heap, (C, A, B))

    answer = 0
    for _ in range(E):
        C, A, B = heapq.heappop(heap)
        if find(A) != find(B):
            union(A, B)
            answer += C

    print(answer)

solution()