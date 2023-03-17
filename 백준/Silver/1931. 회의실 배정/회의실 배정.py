N = int(input())

meetings = []
for _ in range(N):
    meetings.append(list((map(int, input().split()))))

meetings.sort(key=lambda x: (x[1], x[0]))

cnt = 0
end_time = -1
for m in meetings:
    if m[0] >= end_time:
        cnt += 1
        end_time = m[1]

print(cnt)
