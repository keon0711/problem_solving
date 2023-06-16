def solution(dartResult):
    result = []
    
    i = 0
    while i < len(dartResult):
        if dartResult[i:i+2].isdigit():
            n = int(dartResult[i:i+2])
            result.append(n)
            i += 1
        elif dartResult[i].isdigit():
            n = int(dartResult[i])
            result.append(n)
            
        if dartResult[i] == "S":
            pass
        elif dartResult[i] == "D":
            result[-1] = result[-1] ** 2
        elif dartResult[i] == "T":
            result[-1] = result[-1] ** 3
            
        if dartResult[i] == '*':
            result[-1] = 2 * result[-1]
            if len(result) > 1:
                result[-2] = 2 * result[-2]
        elif dartResult[i] == '#':
            result[-1] = -result[-1]
        
        i += 1
            
    return sum(result)