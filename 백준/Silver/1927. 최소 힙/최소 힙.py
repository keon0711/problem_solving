import heapq, sys

Q = []
input = sys.stdin.readline
N = int(input().rstrip())
for _ in range(N):
    command = int(input().rstrip())
    if command == 0:
        print(heapq.heappop(Q) if Q else 0)
    else:
        heapq.heappush(Q, command)
