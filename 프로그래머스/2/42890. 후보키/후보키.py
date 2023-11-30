from itertools import combinations


def solution(relation):
    n = len(relation)
    m = len(relation[0])
    combi = []
    for i in range(1, n + 1):
        combi.extend(combinations(range(m), i))

    candidate_keys = []
    for c in combi:
        tmp = [tuple([row[i] for i in c]) for row in relation]

        if len(set(tmp)) != n:
            continue

        for key in candidate_keys:
            if set(key).issubset(set(c)):
                print('b')
                break
        else:
            candidate_keys.append(c)

    return len(candidate_keys)