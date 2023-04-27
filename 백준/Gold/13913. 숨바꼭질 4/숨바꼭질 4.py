import sys
from collections import deque

def solution():
    MAX_SIZE = 100000
    N, K = map(int, input().split())
    time_table = [-1] * (MAX_SIZE + 1)
    time_table[N] = -2
    Q = deque()
    Q.append(N)
    route = []

    while Q:
        cur_pos = Q.popleft()
        if cur_pos == K:
            break

        for next_pos in (cur_pos * 2, cur_pos - 1, cur_pos + 1):
            if next_pos < 0 or next_pos > MAX_SIZE:
                continue
            if time_table[next_pos] == -1:
                Q.append(next_pos)
                time_table[next_pos] = cur_pos

    while K != -2:
        route.append(K)
        K = time_table[K]

    print(len(route) - 1)
    print(*reversed(route))



solution()
