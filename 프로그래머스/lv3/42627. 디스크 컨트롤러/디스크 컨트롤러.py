import heapq


def solution(jobs: list):
    wait_time = 0
    length = len(jobs)
    jobs.sort(reverse=True)
    heap = []
    heapq.heappush(heap, (jobs[-1][1], jobs[-1][0]))  # (소요시간, 요청시간) 순으로 저장
    jobs.pop()

    start = 0
    end = 0
    while heap or jobs:
        if not heap:
            heapq.heappush(heap, (jobs[-1][1], jobs.pop()[0]))

        cost, request = heapq.heappop(heap)
        start = max(request, end)
        end = cost + start
        wait_time += (end - request)
        while jobs:
            if jobs[-1][0] <= end:
                heapq.heappush(heap, (jobs[-1][1], jobs.pop()[0]))
            else:
                break
    print(wait_time)

    return wait_time // length


print(solution([[0, 3], [1, 9], [2, 6]]))