import sys

input = sys.stdin.readline
N = int(input().rstrip())
S = set()

for _ in range(N):
    command = list(input().split())
    if command[0] == "add":
        S.add(int(command[1]))
    elif command[0] == "remove":
        S.discard(int(command[1]))
    elif command[0] == "check":
        print(1 if int(command[1]) in S else 0)
    elif command[0] == "toggle":
        S.add(int(command[1])) if int(command[1]) not in S else S.discard(int(command[1]))
    elif command[0] == "all":
        S = set(range(1, 21))
    elif command[0] == "empty":
        S.clear()
