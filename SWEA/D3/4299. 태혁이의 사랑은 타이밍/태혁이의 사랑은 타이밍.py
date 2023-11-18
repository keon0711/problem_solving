def calc_min(day, hour, minute):

    return day * 24 * 60 + hour * 60 + minute


T = int(input())

for t in range(T):
    d, h, m = map(int, input().split())
    d -= 11
    answer = max(calc_min(d, h, m) - calc_min(0, 11, 11), -1)

    print(f'#{t + 1} {answer}')