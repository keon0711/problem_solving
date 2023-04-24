import sys
from collections import deque

sys.setrecursionlimit(100000)


def solution():
    A, B = map(int, input().split())
    Q = deque()
    Q.append((A, 1))
    while Q:
        cur_val, cur_cnt = Q.popleft()
        if cur_val == B:
            print(cur_cnt)
            return
        if cur_val > B:
            continue
        Q.append((cur_val * 2, cur_cnt + 1))
        Q.append((cur_val * 10 + 1, cur_cnt + 1))

    print(-1)
    return


solution()
