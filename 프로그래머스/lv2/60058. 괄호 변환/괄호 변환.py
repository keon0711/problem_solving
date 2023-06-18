def reverse_all(brackets):
    brackets = list(brackets)
    for i, bracket in enumerate(brackets):
        if bracket == "(":
            brackets[i] = ")"
        else:
            brackets[i] = "("
            
    return "".join(brackets)
        

def iscorrect(brackets):
    stack = []
    for b in brackets:
        if b == '(':
            stack.append(b)
        elif b == ')':
            if not stack:
                return False
            if stack[-1] == '(':
                stack.pop()
    
    if stack:
        return False
    return True


def solution(p):
    if p == "":
        return ""
    
    count = 0
    u = p
    v = ""
    for i in range(len(p) - 1):
        if count == 0 and i != 0:
            u = p[:i]
            v = p[i:]
            break
        if p[i] == "(":
            count += 1
        elif p[i] == ")":
            count -= 1
    
    print("u : " + u + " v : " + v)
    
    if iscorrect(u):
        return u + solution(v)
    else:
        return "(" + solution(v) + ")" + reverse_all(u[1:-1])