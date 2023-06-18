def solution(queue1, queue2):
    sum1 = sum(queue1)
    sum2 = sum(queue2)
    goal = (sum1 + sum2) // 2
    
    li = queue1 + queue2
    left = 0
    right = len(queue1)
    
    count = 0
    while True:
        if count > 2 * len(li):
            return -1
        
        if sum1 < goal:
            sum1 += li[right]
            right = (right + 1) % len(li)
        elif sum1 > goal:
            sum1 -= li[left]
            left = (left + 1) % len(li)
        else:
            return count
        count += 1
            