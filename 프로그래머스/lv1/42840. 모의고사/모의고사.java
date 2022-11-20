import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] nums3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] scores = new int[]{0, 0, 0};

        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            if (answer == nums1[i % nums1.length]) scores[0]++;
            if (answer == nums2[i % nums2.length]) scores[1]++;
            if (answer == nums3[i % nums3.length]) scores[2]++;
        }
        int maxIdx = 0;
        for (int i = 1; i < 3; i++) {
            if (scores[maxIdx] < scores[i])
                maxIdx = i;
        }
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            if (scores[maxIdx] == scores[i])
                answer.add(i + 1);
        }
        return answer.stream().mapToInt(x -> x).toArray();
    }
}