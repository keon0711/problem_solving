def convert(n, k):
    if n == 0:
        return "0"
    answer = ""

    while n:
        word = str(n % k)
        if '10' <= word <= '16':
            word = chr(ord('A') + int(word) - int('10'))
        answer += word
        n //= k

    return answer[::-1]


def solution(n, t, m, p):
    str = ""
    i = 0
    while len(str) < m * t:
        str += convert(i, n)
        i += 1

    answer = [str[p + i*m - 1] for i in range(t)]

    print(str)
    return "".join(answer)