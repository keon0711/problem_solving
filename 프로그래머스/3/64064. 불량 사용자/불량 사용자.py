def solution(user_id, banned_id):
    def dfs(depth, combinations):
        if depth == l:
            combinations.sort()
            results.append(tuple(combinations))
            return

        for next_id in mapped_id[depth]:
            if next_id not in combinations:
                tmp = combinations[:]
                tmp.append(next_id)
                dfs(depth + 1, tmp)

    results = []
    mapped_id = []

    for b in banned_id:
        candidates = []
        l = len(b)
        for u in user_id:
            if len(u) != l:
                continue

            for i in range(l):
                if b[i] == '*':
                    continue
                if b[i] != u[i]:
                    break
            else:
                candidates.append(u)
        mapped_id.append(candidates)

    l = len(mapped_id)
    dfs(0, [])

    return len(set(results))
