def solution(s):
    num_words = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"]
    result = []
    
    i = 0
    while i < len(s):
        if s[i].isdigit():
            result.append(s[i])
            i += 1
        else:
            for num_word in num_words:
                if s[i:].find(num_word) == 0:
                    result.append(str(num_words.index(num_word)))
                    i += len(num_word)
    
    return int("".join(result))
        