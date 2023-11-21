def solution(stones, k):
    answer = 0
    top = max(stones)
    bottom = 0

    while top >= bottom:
        mid = (top + bottom) // 2
        cnt = 0
        for stone in stones:
            if stone < mid:
                cnt += 1
                if cnt == k: ## 건너기 실패 -> mid 하향 조정
                    top = mid - 1
                    break
            else:
                cnt = 0
        else:   # 건너기 성공 -> 기록한 후 mid 상향 조정
            answer = max(answer, mid)
            bottom = mid + 1

    return answer