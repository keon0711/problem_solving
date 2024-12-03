import java.util.*;

public class Main {

    private static boolean[] visited;
    private static List<Group> groups;
    private static int[] candies;
    private static Map<Integer, List<Integer>> graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        candies = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            candies[i] = sc.nextInt();
        }

        graph = new HashMap<>();
        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            graph.computeIfAbsent(A, k -> new ArrayList<>()).add(B);
            graph.computeIfAbsent(B, k -> new ArrayList<>()).add(A);
        }

        List<Group> groups = new ArrayList<>();
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                groups.add(dfs(i));
            }
        }

        int[][] dp = new int[groups.size() + 1][K + 1];

        for (int i = 1; i <= groups.size(); i++) {
            for (int j = 0; j <= K; j++) {
                Group group = groups.get(i - 1);

                if (group.people <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - group.people] + group.candy);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[groups.size()][K - 1]);

    }

    private static Group dfs(int i) {
        visited[i] = true;

        List<Integer> friends = graph.getOrDefault(i, Collections.emptyList());
        Group group = new Group(candies[i], 1);

        for (int friend : friends) {
            if (!visited[friend]) {
                group.add(dfs(friend));
            }
        }

        return group;
    }

    static class Group {

        int candy;
        int people;

        public Group(int candy, int people) {
            this.candy = candy;
            this.people = people;
        }

        public void add(Group group) {
            this.candy += group.candy;
            this.people += group.people;
        }

        @Override
        public String toString() {
            return "Group{" +
                "candy=" + candy +
                ", people=" + people +
                '}';
        }
    }

}