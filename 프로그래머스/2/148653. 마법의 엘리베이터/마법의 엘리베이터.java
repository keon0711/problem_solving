import java.util.*;

class Solution {
    private Map<Integer, Integer> memo = new HashMap<>();

    public int solution(int storey) {
        return dfs(storey);
    }

    private int dfs(int floor) {
        if (floor == 0) return 0;
        if (floor < 10) return Math.min(floor, 11 - floor);
        if (memo.containsKey(floor)) return memo.get(floor);

        int digit = floor % 10;
        int down = digit + dfs(floor / 10);
        int up = (10 - digit) + dfs(floor / 10 + 1);

        int result = Math.min(down, up);
        memo.put(floor, result);
        return result;
    }
}