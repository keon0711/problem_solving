from collections import defaultdict


def find_best_seat(valid_seats):
    max_value = -1
    max_seat = 0

    for seat in valid_seats:
        if classroom[seat[0]][seat[1]] > max_value:
            max_value = classroom[seat[0]][seat[1]]
            max_seat = seat

    return max_seat


def is_close(A, B):
    if abs(A[0] - B[0]) + abs(A[1] - B[1]) == 1:
        return True


N = int(input())
classroom = [[4] * N for _ in range(N)]

for i in range(N):
    classroom[i][0] -= 1
    classroom[i][N - 1] -= 1
    classroom[0][i] -= 1
    classroom[N - 1][i] -= 1


seats = [0 for _ in range(N ** 2 + 1)]
empty_seats = [(x, y) for x in range(N) for y in range(N)]
preferences = [0 for _ in range(N ** 2 + 1)]
directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]

for _ in range(N ** 2):
    student, *preference = map(int, input().split())
    preferences[student] = list(preference)

    adjacent_seat = defaultdict(int)
    for close_friend in preference:
        if seats[close_friend] == 0: # 아직 앉지 않음
            continue

        for dx, dy in directions: # 친구랑 가까운 자리 카운트
            x, y = seats[close_friend][0] + dx, seats[close_friend][1] + dy
            if 0 <= x < N and 0 <= y < N and classroom[x][y] != -1: # 자리가 비어있음
                adjacent_seat[(x, y)] += 1

    valid_seats = []
    # 친한 친구가 있는 자리가 있는 빈 자리
    if adjacent_seat:
        most_adjacent = max(adjacent_seat.values())
        valid_seats = [seat for seat in adjacent_seat.keys() if adjacent_seat[seat] == most_adjacent]
        valid_seats.sort()
        my_seat = find_best_seat(valid_seats)
    else:
        my_seat = find_best_seat(empty_seats)

    empty_seats.remove(my_seat)
    classroom[my_seat[0]][my_seat[1]] = -1
    seats[student] = my_seat
    # 인접 빈 자리 개수 줄이기
    for dx, dy in directions:
        x, y = my_seat[0] + dx, my_seat[1] + dy
        if 0 <= x < N and 0 <= y < N and classroom[x][y] > 0:
            classroom[x][y] -= 1

answer = 0
score = [0, 1, 10, 100, 1000]
for i in range(1, N**2 + 1):
    cnt = 0
    for p in preferences[i]:
        if is_close(seats[i], seats[p]):
            cnt += 1

    answer += score[cnt]

print(answer)