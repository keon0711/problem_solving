def solution(msg):
    def find_longest_word(i):
        for j in range(i + 1, len(msg) + 1):
            if msg[i:j] in dic:
                continue
            else:
                return msg[i:j - 1]

        return msg[i:]


    dic = dict()

    for i in range(26):
        dic[chr(ord("A") + i)] = i + 1

    result = []
    i = 0
    while i < len(msg):
        longest_word = find_longest_word(i)
        result.append(dic[longest_word])
        i += len(longest_word)
        if i < len(msg):
            dic[longest_word + msg[i]] = len(dic) + 1

    return result