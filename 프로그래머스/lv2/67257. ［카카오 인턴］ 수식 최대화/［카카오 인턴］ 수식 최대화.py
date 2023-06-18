from itertools import permutations
from collections import deque

def solution(expression):
    def operate(a, b, op):
        if op == '+':
            return str(int(a) + int(b))
        if op == '-':
            return str(int(a) - int(b))
        if op == '*':
            return str(int(a) * int(b))
    
    
    def calc(priority):
        q1 = deque()
        q2 = deque(exp)
        
        for p in priority:
            print(p)
            while q2:
                if q2[0] == p:
                    q2.popleft()
                    q1.append(operate(q1.pop(), q2.popleft(), p))
                else:
                    q1.append(q2.popleft())
            
            q1, q2 = q2, q1
        
        result.append(abs(int(q2[0])))
    
    
    op = "+-*"
    result = []
    
    exp = []
    start = 0
    for end in range(len(expression)):
        if expression[end] in op:
            exp.append(expression[start:end])
            exp.append(expression[end])
            start = end + 1
    exp.append(expression[start:])
    
    priorities = list(permutations(op))
    for p in priorities:
        calc(p)
    
    return max(result)