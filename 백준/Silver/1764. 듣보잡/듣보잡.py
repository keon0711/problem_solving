import sys

input = sys.stdin.readline
N, M = map(int, input().split())
heard = set()

for _ in range(N):
    heard.add(input().rstrip())

cnt = 0
heard_seen = []
for _ in range(M):
    seen = input().rstrip()
    if seen in heard:
        cnt += 1
        heard_seen.append(seen)

print(cnt)
for x in sorted(heard_seen):
    print(x)