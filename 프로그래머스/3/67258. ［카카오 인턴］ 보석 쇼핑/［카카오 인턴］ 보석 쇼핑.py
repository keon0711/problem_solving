from collections import defaultdict


def solution(gems):
    answer = []
    counter = defaultdict(int)
    size = len(set(gems))

    start = end = 0
    while end < len(gems):
        counter[gems[end]] += 1

        while counter[gems[start]] > 1:
            counter[gems[start]] -= 1
            start += 1
        if len(counter) == size:
            answer.append((start + 1, end + 1))
        end += 1

    answer.sort(key=lambda x: x[1] - x[0])
    return answer[0]