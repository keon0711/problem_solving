N = int(input())
time = list(map(int, input().split()))
time.sort()

answer = []
total_time = 0
for t in time:
    total_time += t
    answer.append(total_time)

print(sum(answer))
