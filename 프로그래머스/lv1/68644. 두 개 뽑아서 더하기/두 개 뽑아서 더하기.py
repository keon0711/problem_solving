from itertools import combinations

def solution(numbers):
    result = set()
    for c in combinations(numbers, 2):
        result.add(sum(c))
    
    return sorted(list(result))
    