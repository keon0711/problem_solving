import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int maxMinerals = Math.min(minerals.length, Arrays.stream(picks).sum() * 5);

        List<int[]> groups = IntStream.range(0, maxMinerals)
            .filter(i -> i % 5 == 0)
            .mapToObj(i -> Arrays.copyOfRange(minerals, i, Math.min(i + 5, maxMinerals)))
            .map(this::calculateGroupValue)
            .sorted((a, b) -> Arrays.stream(b).sum() - Arrays.stream(a).sum())
            .collect(Collectors.toList());

        return groups.stream()
            .mapToInt(group -> calculateFatigue(group, picks))
            .sum();
    }

    private int[] calculateGroupValue(String[] minerals) {
        return Arrays.stream(minerals)
            .mapToInt(s -> s.charAt(0) == 'd' ? 25 : s.charAt(0) == 'i' ? 5 : 1)
            .toArray();
    }

    private int calculateFatigue(int[] group, int[] picks) {
        int pickPower = picks[0]-- > 0 ? 25 : picks[1]-- > 0 ? 5 : 1;
        return Arrays.stream(group)
            .map(mineral -> Math.max(mineral / pickPower, 1))
            .sum();
    }
}