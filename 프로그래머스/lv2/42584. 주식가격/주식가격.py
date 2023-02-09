from collections import deque

def solution(prices):
    Q = deque(prices)
    answer = []

    while Q:
        cur = Q.popleft()
        days = 0
        for x in Q:
            days += 1
            if cur > x:
                break
        answer.append(days)

    return answer