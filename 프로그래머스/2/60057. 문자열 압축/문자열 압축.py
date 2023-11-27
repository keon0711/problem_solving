def solution(s):
    def compress(unit):
        result = ""

        i = 0
        while i < len(s):
            cnt = 1
            word = s[i:i + unit]
            while True:
                next_word = s[i + unit: i + 2 * unit]
                if word == next_word:
                    cnt += 1
                    i += unit
                else:
                    if cnt == 1:
                        result += word
                    else:
                        result += f'{cnt}{word}'
                    i += unit
                    break

        return len(result)

    l = len(s)
    min_len = l
    for i in range(1, l // 2 + 1):
        min_len = min(min_len, compress(i))
    return min_len

