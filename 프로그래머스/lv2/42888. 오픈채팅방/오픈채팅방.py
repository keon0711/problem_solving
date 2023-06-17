from collections import defaultdict

def solution(record):
    d = defaultdict(str)
    tmp = []
    
    for r in record:
        li = r.split()
        if li[0] == "Enter" or li[0] == "Leave":
            tmp.append((li[0], li[1]))
        if li[0] == "Enter" or li[0] == "Change":
            d[li[1]] = li[2]
    
    answer = []
    for action, user_id in tmp:
        if action == "Enter":
            answer.append(d[user_id] + "님이 들어왔습니다.")
        if action == "Leave":
            answer.append(d[user_id] + "님이 나갔습니다.")
    
    return answer