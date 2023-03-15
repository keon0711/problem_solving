from math import factorial

def solution(n, k):
    li = [i+1 for i in range(n)]
    n -= 1
    k -= 1
    answer = []
    for i in range(n, -1, -1):
        m = k // factorial(i)
        answer.append(li[m])
        li = li[:m] + li[m+1:]
        k %= factorial(i)
    return answer

print(solution(3, 5))