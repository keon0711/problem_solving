import java.util.Arrays;
import java.util.Comparator;

class Solution {

    public int solution(int[][] routes) {

        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));


        int lastCamera = Integer.MIN_VALUE;
        int numberOfCamera = 0;
        for (int[] route : routes) {
            if (lastCamera < route[0]) {
                lastCamera = route[1];
                numberOfCamera++;
            }
        }

        return numberOfCamera;
    }
}