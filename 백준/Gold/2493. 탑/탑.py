import sys
input = sys.stdin.readline

N = int(input())
towers = list(map(int, input().split()))
stack = []
answer = []
for i in range(N):
    height = towers[i]
    while stack and towers[stack[-1]] < height:
        stack.pop()

    if len(stack) == 0:
        answer.append(0)
    else:
        answer.append(stack[-1] + 1)
    stack.append(i)

print(*answer)

