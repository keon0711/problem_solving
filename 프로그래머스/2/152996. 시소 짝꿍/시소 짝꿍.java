import java.util.HashMap;
import java.util.Map;

class Solution {

    public long solution(int[] weights) {

        Map<Integer, Integer> counter = new HashMap<>();
        long answer = 0;

        for (int weight : weights) {
            counter.merge(weight, 1, Integer::sum);
        }

        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            int weight = entry.getKey();
            int count = entry.getValue();

            // 1 : 1
            // count 중 2명을 뽑는 경우의 수
            if (count > 1) {
                answer += (long) count * (count - 1) / 2;
            }

            // 1 : 3/2
            if (weight % 2 == 0) {
                answer += calcPair(weight * 3 / 2, counter, count);
            }

            // 1 : 4/3
            if (weight % 3 == 0) {
                answer += calcPair(weight * 4 / 3, counter, count);
            }

            // 1 : 2
            answer += calcPair(weight * 2, counter, count);
        }

        return answer;

    }

    private static long calcPair(int targetWeight, Map<Integer, Integer> counter, long count) {
        int targetCount = counter.getOrDefault(targetWeight, 0);
        return count * targetCount;
    }
}