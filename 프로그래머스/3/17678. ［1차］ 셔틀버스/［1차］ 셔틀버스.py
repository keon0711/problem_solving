from collections import deque


def solution(n, t, m, timetable):
    def time_to_min(time):
        h, m = time.split(":")

        return 60 * int(h) + int(m)

    def min_to_time(minute):
        return f'{minute // 60:02d}:{minute % 60:02d}'

    def timetable_to_min(table):
        return deque(sorted(map(time_to_min, table)))

    arrival_time = timetable_to_min(timetable)
    buses = [9 * 60 + t * i for i in range(n)]

    for i in range(n - 1):
        bus_time = buses[i]
        for j in range(m):
            if not arrival_time:
                break
            if arrival_time[j] > bus_time:
                break
            arrival_time.popleft()

    if len(arrival_time) < m:
        return min_to_time(buses[-1])
        
    last_time = buses[-1] if buses[-1] < arrival_time[m - 1] else arrival_time[m - 1] - 1
    return min_to_time(last_time)