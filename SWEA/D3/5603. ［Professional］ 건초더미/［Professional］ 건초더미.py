T = int(input())

for t in range(T):
    N = int(input())
    S = [int(input()) for _ in range(N)]
    avr = sum(S) // len(S)

    answer = 0
    for s in S:
        if s > avr:
            answer += (s - avr)
    print(f'#{t + 1} {answer}')