import java.util.Arrays;
import java.util.Comparator;

class Solution {

    public int solution(int[][] targets) {
        Arrays.sort(targets, Comparator.comparingInt(a -> a[1]));

        int count = 0;
        double lastShot = -1;

        for (int[] target : targets) {
            if (target[0] > lastShot) {
                count++;
                lastShot = target[1] - 0.1;
            }
        }
        
        return count;
    }
}