import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        int answer = 0;
        int n = score.length;

        for (int i = n; i >= m; i -= m) {
            int minScore = score[i - m];
            answer += minScore * m;
        }

        return answer;
    }
}