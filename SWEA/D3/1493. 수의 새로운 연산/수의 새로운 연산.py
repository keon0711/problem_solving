T = int(input())

MAX_NUM = 500

num_to_pos = [0]
pos_to_num = [[0] * MAX_NUM for _ in range(MAX_NUM)]

num = 0
for i in range(1, MAX_NUM):
    for j in range(1, i + 1):
        num += 1
        pos_to_num[j][i - j + 1] = num
        num_to_pos.append((j, i - j + 1))


for t in range(T):
    p, q = map(int, input().split())
    a, b = num_to_pos[p]
    c, d = num_to_pos[q]
    answer = pos_to_num[a+c][b + d]

    print(f'#{t + 1} {answer}')