import java.util.HashMap;
import java.util.Map;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String c : completion) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (String p : participant) {
            Integer count = map.getOrDefault(p, 0);
            if (count == 0) {
                return p;
            } else {
                map.put(p, count - 1);
            }
        }
        return "";
    }
}