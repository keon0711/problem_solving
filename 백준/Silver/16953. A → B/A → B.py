import sys
from collections import deque

sys.setrecursionlimit(100000)


def solution():
    A, B = map(int, input().split())
    Q = deque()
    Q.append((B, 1))
    while Q:
        cur_val, cur_cnt = Q.popleft()
        if cur_val == A:
            print(cur_cnt)
            return
        if cur_val < A:
            continue
        if cur_val % 2 == 0:
            Q.append((cur_val // 2, cur_cnt + 1))
        if cur_val % 10 == 1:
            Q.append((cur_val // 10, cur_cnt + 1))

    print(-1)
    return


solution()
