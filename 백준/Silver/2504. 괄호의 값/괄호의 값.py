import sys


def dfs(cur):
    val = 0
    while brackets:
        next = brackets.pop()
        if next == '(' or next == '[':
            val += dfs(next)
        elif cur == '(' and next == ')':
            val = 2 * max(1, val)
            return val
        elif cur == '[' and next == ']':
            val = 3 * max(1, val)
            return val

    print(0)
    sys.exit()


brackets = list(input())[::-1]
result = 0
while brackets:
    result += dfs(brackets.pop())
print(result)
