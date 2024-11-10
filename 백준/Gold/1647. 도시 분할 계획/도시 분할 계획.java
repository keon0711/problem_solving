import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, R, Q;
    static List<Integer>[] tree;
    static int[] subtreeSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            graph.get(A).add(new Edge(B, C));
            graph.get(B).add(new Edge(A, C));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.cost));
        pq.add(new Edge(1, 0));
        boolean[] visited = new boolean[N + 1];

        int totalCost = 0;
        int maxCostEdge = 0;
        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (visited[cur.to]) {
                continue;
            }

            visited[cur.to] = true;
            totalCost += cur.cost;
            maxCostEdge = Math.max(cur.cost, maxCostEdge);
            for (Edge next : graph.get(cur.to)) {
                if (!visited[next.to]) {
                    pq.add(next);
                }
            }
        }

        System.out.println(totalCost - maxCostEdge);

    }

    static class Edge {

        int to;
        int cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

}
