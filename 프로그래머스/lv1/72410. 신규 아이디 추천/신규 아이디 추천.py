import re

def solution(new_id):
    # 1, 2단계
    result = ""
    for c in new_id.lower():
        if c.isalnum() or c in ["-", "_", "."]:
            result += c

    # 3단계
    result = re.sub("[.]{2,}", ".", result)

    # 4
    if result != "" and result[0] == '.':
        result = result[1:]
        
    if result != "" and result[-1] == '.':
        result = result[:-1]

    # 5
    if result == "":
        result = "a"

    # 6
    if len(result) >= 16:
        result = result[:16]
    if result[-1] == ".":
        result = result[:-1]

    # 7
    while len(result) <= 2:
        result += result[-1]
        
    #6
    if len(result) >= 16:
        result = result[:15]
    if result[-1] == ".":
        result = result[:-1]
        
    #7
    while len(result) <= 2:
        result += result[-1]
        
    return result