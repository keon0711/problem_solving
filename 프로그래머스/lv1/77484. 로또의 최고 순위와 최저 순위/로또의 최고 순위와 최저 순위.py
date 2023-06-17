def solution(lottos, win_nums):
    count_correct = 0
    count_zero = 0
    prize = [6, 6, 5, 4, 3, 2, 1]
    
    for l in lottos:
        if l == 0:
            count_zero += 1
        elif l in win_nums:
            count_correct += 1

    return [prize[count_correct + count_zero], prize[count_correct]]