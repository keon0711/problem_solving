from collections import defaultdict

N, M = map(int, input().split())
DICT = defaultdict(int)
LIST = [""] * (N + 1)

for i in range(1, N + 1):
    name = input()
    DICT[name] = i
    LIST[i] = name

for _ in range(M):
    question = input()
    if question.isnumeric():
        print(LIST[int(question)])
    else:
        print(DICT[question])