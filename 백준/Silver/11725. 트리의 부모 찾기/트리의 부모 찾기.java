import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            map.computeIfAbsent(a, k -> new ArrayList<>()).add(b);
            map.computeIfAbsent(b, k -> new ArrayList<>()).add(a);
        }

        int[] parents = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        dfs(map, parents, visited, 1);

        for (int i = 2; i <= n; i++) {
            System.out.println(parents[i]);
        }
    }

    private static void dfs(Map<Integer, List<Integer>> map, int[] parents, boolean[] visited, int parent) {
        visited[parent] = true;

        for (int child : map.getOrDefault(parent, new ArrayList<>())) {
            if (!visited[child]) {
                parents[child] = parent;
                dfs(map, parents, visited, child);
            }
        }
    }
}