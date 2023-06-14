def solution(s):
    def check(s):
        stack = []
        for c in s:
            if c == "]":
                if not stack or stack[-1] != "[":
                    return False
                stack.pop()
            
            elif c == "}":
                if not stack or stack[-1] != "{":
                    return False
                stack.pop()
                
            elif c == ")":
                if not stack or stack[-1] != "(":
                    return False
                stack.pop()
                
            else:
                stack.append(c)
            
        if stack:
            return False
        return True
        
        
    answer = 0
    for i in range(len(s)):
        if check(s):
            answer += 1
        s = s[1:] + s[0]
    
    return answer