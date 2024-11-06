import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    static int N;
    static List<String> cities = new ArrayList<>();
    static Map<String, List<String>> map = new HashMap<>();

    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, Comparator.comparing(a -> a[1]));
        N = tickets.length;

        for (String[] ticket : tickets) {
            map.computeIfAbsent(ticket[0], k -> new ArrayList<>())
                .add(ticket[1]);
        }

        cities.add("ICN");
        dfs("ICN", 0);
        System.out.println(cities);
        return cities.toArray(String[]::new);
    }

    private boolean dfs(String from, int count) {
        if (count == N) {
            return true;
        }

        if (!map.containsKey(from) || map.get(from).isEmpty()) {
            return false;
        }

        List<String> destinations = map.get(from);
        for (int i = 0; i < destinations.size(); i++) {
            String to = destinations.get(i);

            cities.add(to);
            destinations.remove(i);

            if (dfs(to, count + 1)) {
                return true;
            }

            destinations.add(i, to);
            cities.remove(cities.size() - 1);
        }

        return false;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] answer = solution.solution(
            new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}});
    }
}