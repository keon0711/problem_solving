import java.util.Arrays;

class Solution {

    public long solution(int n, int[] times) {
        long answer = 0;

        long left = 1;
        long right = (long) Arrays.stream(times).min().getAsInt() * n;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            long calcN = 0;
            for (int time : times) {
                calcN += (mid / time);
            }
            if (calcN < n) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }
        return answer;
    }
}