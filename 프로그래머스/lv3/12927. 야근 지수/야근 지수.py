import heapq


def solution(n, works):
    if sum(works) <= n:
        return 0

    works = [-work for work in works]
    heapq.heapify(works)
    while n:
        heapq.heappush(works, heapq.heappop(works) + 1)
        n -= 1

    return sum(i**2 for i in works)

print(solution(4, [4,3,3]))