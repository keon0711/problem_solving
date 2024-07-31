import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] answers) {

        List<int[]> students = new ArrayList<>();
        students.add(new int[]{1, 2, 3, 4, 5});
        students.add(new int[]{2, 1, 2, 3, 2, 4, 2, 5});
        students.add(new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5});

        int[] scores = new int[3];
        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < students.size(); j++) {
                int[] student = students.get(j);
                if (answers[i] == student[i % student.length]) {
                    scores[j]++;
                }
            }
        }

        int max = IntStream.of(scores).max().orElse(0);
        return IntStream.range(0, scores.length).filter(i -> scores[i] == max).map(i -> i + 1).toArray();
    }
}