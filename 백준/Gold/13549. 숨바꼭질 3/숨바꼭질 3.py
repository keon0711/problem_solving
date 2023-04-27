import sys
from collections import deque

def solution():
    N, K = map(int, input().split())
    time_table = [-1] * 100001
    time_table[N] = 0
    Q = deque()
    Q.append(N)

    while Q:
        cur_pos = Q.popleft()
        if cur_pos == K:
            break

        if 0 <= cur_pos * 2 <= 100000 and time_table[cur_pos * 2] == -1:
            time_table[cur_pos * 2] = time_table[cur_pos]
            Q.appendleft(cur_pos * 2)
        for next_pos in [cur_pos - 1, cur_pos + 1]:
            if 0 <= next_pos <= 100000 and time_table[next_pos] == - 1:
                time_table[next_pos] = time_table[cur_pos] + 1
                Q.append(next_pos)

    print(time_table[K])


solution()
