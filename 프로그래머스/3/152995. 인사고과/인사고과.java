import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] scores) {
        int[] targetScore = scores[0];

        Arrays.sort(scores, Comparator.comparingInt((int[] a) -> a[0]).reversed().thenComparingInt((int[] a) -> a[1]));

        int rank = 1;
        int maxB = 0;
        for (int[] score : scores) {
            if (targetScore[0] < score[0] && targetScore[1] < score[1]) {
                return -1;
            }
            if (maxB <= score[1]) {
                maxB = score[1];
                if (score[0] + score[1] > targetScore[0] + targetScore[1]) {
                    rank++;
                }
            }
        }

        return rank;
    }
}