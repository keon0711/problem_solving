import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];

        Map<Character, Integer> counter = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (counter.containsKey(c)) {
                answer[i] = i - counter.get(c);
            } else {
                answer[i] = -1;
            }
            counter.put(c, i);

        }

        return answer;
    }
}