def solution(arr):
    def gcd(a, b):
        if a < b:
            return gcd(b, a)
        if b == 0:
            return a
        return gcd(b, a % b)

    def lcm(a, b):
        return a * b // gcd(a, b)

    while len(arr) > 1:
        arr.append(lcm(arr.pop(), arr.pop()))

    return arr[0]


print(solution([2, 6, 8, 14]))
