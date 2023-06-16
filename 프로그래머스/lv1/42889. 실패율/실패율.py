from collections import Counter
from heapq import heappush, heappop

def solution(N, stages):
    c = Counter(stages)
    not_visited = set([i for i in range(1, N + 1)])
    
    clear = len(stages)
    heap = []
    
    for i in sorted(list(set(stages))):
        if i == N + 1:
            break
        heappush(heap, (-(c[i] / clear), i))
        clear -= c[i]
        not_visited.remove(i)
    
    result = []
    while heap:
        result.append(heappop(heap)[1])
    
    for v in not_visited:
        result.append(v)
    
    return result        