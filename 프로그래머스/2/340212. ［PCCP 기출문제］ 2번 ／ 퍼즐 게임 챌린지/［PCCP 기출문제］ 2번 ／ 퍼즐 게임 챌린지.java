import java.util.*;

class Solution {

    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = Arrays.stream(diffs).max().getAsInt();
        Set<Integer> successLevel = new HashSet<>();

        while (left <= right) {
            int mid = (left + right) / 2;
            long time = getTime(diffs, times, mid);

            if (time <= limit) {
                successLevel.add(mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return successLevel.stream().min(Integer::compare).get();
    }

    private long getTime(int[] diffs, int[] times, int level) {
        long time = 0L;
        long timePrev = 0;
        for (int i = 0; i < diffs.length; i++) {
            int timeCur = times[i];
            if (diffs[i] <= level) {
                time += timeCur;
            } else {
                time += (timeCur + timePrev) * (diffs[i] - level) + timeCur;
            }
            timePrev = timeCur;
        }
        return time;
    }
}