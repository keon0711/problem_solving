from collections import defaultdict

def solution(survey, choices):
    mbti = ["RT", "CF", "JM", "AN"]
    score = [0, 3, 2, 1, 0, -1, -2, -3]
    record = defaultdict(int)
    
    for i in range(len(survey)):
        record[survey[i][0]] += score[choices[i]]
        record[survey[i][1]] -= score[choices[i]]
    
    result = ""
    for m in mbti:
        if record[m[0]] >= record[m[1]]:
            result += m[0]
        else:
            result += m[1]
            
    return result