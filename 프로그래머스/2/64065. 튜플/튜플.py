def str_to_list(s):
    li = s[2:-2].split('},{')
    li.sort(key= lambda x: len(x))
    return [list(map(int, x.split(','))) for x in li]


def solution(s: str):
    answer = []
    already_added = set()

    s = str_to_list(s)

    for d in s:
        for c in d:
            if c not in already_added:
                answer.append(c)
                already_added.add(c)

    return answer