import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] indgree = new int[N + 1];
        List<Integer>[] graph = new List[N + 1];
        Arrays.setAll(graph, i -> new ArrayList<>());

        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            graph[from].add(to);
            indgree[to]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Integer::compareTo);

        for (int i = 1; i <= N; i++) {
            if (indgree[i] == 0) {
                pq.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int current = pq.poll();
            sb.append(current).append(" ");

            for (int next : graph[current]) {
                indgree[next]--;
                if (indgree[next] == 0) {
                    pq.add(next);
                }
            }
        }

        System.out.println(sb);

    }

}