def solution(board, moves):
    rotated_board = list(map(list, zip(*board[::-1])))
    result = 0
    stack = []
    
    for b in rotated_board:
        while b and b[-1] == 0:
            b.pop()
    
    for move in moves:
        if rotated_board[move - 1]:
            doll = rotated_board[move - 1].pop()
            
            if stack and doll == stack[-1]:
                stack.pop()
                result += 2
            else:
                stack.append(doll)
    
    return result
            