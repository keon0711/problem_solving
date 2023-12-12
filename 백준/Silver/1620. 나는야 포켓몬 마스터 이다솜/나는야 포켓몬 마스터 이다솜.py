import sys

input = sys.stdin.readline
N, M = map(int, input().split())
DICT = dict()
LIST = [""] * (N + 1)

for i in range(1, N + 1):
    name = input().rstrip()
    DICT[name] = i
    LIST[i] = name

for _ in range(M):
    question = input().rstrip()
    if question.isnumeric():
        print(LIST[int(question)])
    else:
        print(DICT[question])