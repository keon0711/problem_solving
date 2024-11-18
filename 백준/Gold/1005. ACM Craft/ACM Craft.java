import java.util.*;

public class Main {

    private static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            simulate();
        }
    }

    private static void simulate() {
        int N = sc.nextInt();
        int K = sc.nextInt();

        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] originalCosts = new int[N + 1];
        int[] inDegree = new int[N + 1];
        int[] requiredCosts = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            originalCosts[i] = sc.nextInt();
        }

        for (int i = 0; i < K; i++) {
            int from  = sc.nextInt();
            int to = sc.nextInt();
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
            inDegree[to]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int W = sc.nextInt();
        while (!queue.isEmpty()) {
            int from = queue.poll();

            if (from == W) {
                System.out.println(requiredCosts[from] + originalCosts[from]);
                return;
            }

            List<Integer> nextBuildings = graph.getOrDefault(from, new ArrayList<>());
            for (int to : nextBuildings) {
                inDegree[to]--;
                requiredCosts[to] = Math.max(requiredCosts[to], requiredCosts[from] + originalCosts[from]);
                if (inDegree[to] == 0) {
                    queue.add(to);
                }
            }
        }
    }
}