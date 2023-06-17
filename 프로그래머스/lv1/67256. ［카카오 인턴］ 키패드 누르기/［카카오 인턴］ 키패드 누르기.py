def solution(numbers, hand):
    def find_closer_hand(n):
        distance = [0, 0]
        distance[0] = abs(pos[n][0] - left_hand[0]) + abs(pos[n][1] - left_hand[1])
        distance[1] = abs(pos[n][0] - right_hand[0]) + abs(pos[n][1] - right_hand[1])
        
        if distance[0] < distance[1]:
            return 0
        if distance[0] > distance[1]:
            return 1
        if distance[0] == distance[1]:
            return 2
        
    
    pos = [(3, 1), (0, 0), (0, 1), (0, 2), (1, 0), (1, 1), (1, 2), (2, 0), (2, 1), (2, 2)]
    
    left_hand = (3, 0)
    right_hand = (3, 2)
    result = []
    
    for number in numbers:
        if number in [1, 4, 7]:
            result.append("L")
            left_hand = pos[number]
        elif number in [3, 6, 9]:
            result.append("R")
            right_hand = pos[number]
        elif number in [2, 5, 8, 0]:
            closer_hand = find_closer_hand(number)
            if closer_hand == 0 or (closer_hand == 2 and hand == "left"):
                result.append("L")
                left_hand = pos[number]
            elif closer_hand == 1 or (closer_hand == 2 and hand == "right"):
                result.append("R")
                right_hand = pos[number]
    
    return "".join(result)
            
            
            