original_string = input()
explosion_string = input()
l = len(explosion_string)

answer = []
for i in range(len(original_string)):
    answer.append(original_string[i])
    if "".join(answer[-l:]) == explosion_string:
        for _ in range(l):
            answer.pop()

print("".join(answer) if answer else "FRULA")
