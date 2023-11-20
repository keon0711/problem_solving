def convert(n, k):
    answer = ""

    while n:
        answer += str(n % k)
        n //= k

    return answer[::-1]


def is_prime(n):
    if not n:
        return False

    n = int(n)

    if n == 1:
        return False

    for i in range(2, int(n ** 0.5) + 1):
        if n % i == 0:
            return False

    return True


def solution(n, k):
    nums = convert(n, k).split('0')
    answer = list(map(is_prime, nums)).count(True)

    return answer