from collections import deque

N = int(input())
Q = deque()
Q.append((N, 0))
while Q:
    num, cnt = Q.popleft()
    if num == 1:
        print(cnt)
        break
    if num % 3 == 0:
        Q.append((num // 3, cnt + 1))
    if num % 2 == 0:
        Q.append((num // 2, cnt + 1))
    Q.append((num - 1, cnt + 1))

