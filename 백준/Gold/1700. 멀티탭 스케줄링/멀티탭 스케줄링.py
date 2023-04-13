def remove(i):
    latest = 0
    for m in multitap:
        if m not in arr[i + 1:]:
            multitap.remove(m)
            return
        latest = max(latest, arr[i:].index(m) + i)
    multitap.remove(arr[latest])


N, K = map(int, input().split())
arr = list(map(int, input().split()))
multitap = set()
cnt = 0
for i in range(K):
    if arr[i] in multitap:
        continue
    if len(multitap) >= N:
        remove(i)
        cnt += 1
    multitap.add(arr[i])
print(cnt)