H, W = map(int, input().split())
blocks = list(map(int, input().split()))
stack = []
volume = 0

for i in range(len(blocks)):
    while stack and blocks[i] > blocks[stack[-1]]:
        top = stack.pop()

        if not stack:
            break
        distance = i - stack[-1] - 1
        waters = min(blocks[i], blocks[stack[-1]]) - blocks[top]
        volume += distance * waters
    stack.append(i)

print(volume)