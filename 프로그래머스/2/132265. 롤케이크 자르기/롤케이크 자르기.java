import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        Map<Integer, Integer> rightMap = new HashMap<>();
        for (int t : topping) {
            rightMap.merge(t, 1, Integer::sum);  // merge로 개선
        }

        Set<Integer> leftSet = new HashSet<>();

        for (int t : topping) {
            leftSet.add(t);

            rightMap.put(t, rightMap.get(t) - 1);
            if (rightMap.get(t) == 0) {
                rightMap.remove(t);
            }

            if (leftSet.size() == rightMap.size()) {
                answer++;
            }
        }

        return answer;
    }
}