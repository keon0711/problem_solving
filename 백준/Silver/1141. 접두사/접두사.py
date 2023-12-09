N = int(input())
words = [input() for _ in range(N)]
words.sort(key=lambda x: len(x))
answer = 0

for i in range(N):
    word = words[i]
    for j in range(i + 1, N):
        if words[j].startswith(word):
            break
    # 다른 단어들의 접두사가 아니면
    else:
        answer += 1

print(answer)
