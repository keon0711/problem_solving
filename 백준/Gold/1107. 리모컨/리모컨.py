from collections import deque


N = int(input())
M = int(input())
if M != 0:
    broken_button = input().split()
else:
    broken_button = set()
current_channel = 100
visited = [False] * 2000000

Q = deque()
Q.append(N)
visited[N] = True
while Q:
    num = Q.popleft()
    if num > 1500000:
        break
    for c in str(num):
        if c in broken_button:
            if num - 1 >= 0 and not visited[num - 1]:
                visited[num - 1] = True
                Q.append(max(num - 1, 0))
            if not visited[num + 1]:
                visited[num + 1] = True
                Q.append(num + 1)
            break
    else:
        break

print(min(abs(current_channel - N), len(str(num)) + abs(num - N)))