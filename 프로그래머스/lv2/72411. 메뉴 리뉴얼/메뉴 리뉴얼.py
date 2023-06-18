from itertools import combinations
from collections import defaultdict

def solution(orders, course):
    result = []
    
    for c in course:
        counter = defaultdict(int)
        for order in orders:
            order = sorted(order)
            for comb in combinations(order, c):
                counter["".join(comb)] += 1
        
        if not counter:
            continue
            
        sorted_counter = sorted(counter.items(), reverse = True, key = lambda x:x[1])
        print(sorted_counter)
        for s in sorted_counter:
            if s[1] < 2 or s[1] != sorted_counter[0][1]:
                break
            result.append(s[0])

    return sorted(result)