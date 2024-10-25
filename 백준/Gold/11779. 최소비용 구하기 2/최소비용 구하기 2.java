import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static List<List<Edge>> graph = new ArrayList<>();
    static long[] dist;
    static int[] prev;
    private static int n;
    private static int m;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();

            graph.get(from).add(new Edge(to, cost));
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        dijkstra(start, end);

        List<Integer> path = new ArrayList<>();
        for (int i = end; i != 0; i = prev[i]) {
            path.add(i);
        }
        Collections.reverse(path);

        System.out.println(dist[end]);
        System.out.println(path.size());

        for (Integer integer : path) {
            System.out.print(integer + " ");
        }
    }

    private static void dijkstra(int start, int end) {
        dist = new long[n + 1];
        prev = new int[n + 1];

        Arrays.fill(dist, Long.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingLong(node -> node.cost));
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (cur.value == end) {
                return;
            }

            for (Edge next : graph.get(cur.value)) {
                if (dist[cur.value] + next.cost < dist[next.value]) {
                    dist[next.value] = dist[cur.value] + next.cost;
                    prev[next.value] = cur.value;
                    pq.offer(new Edge(next.value, (int)dist[next.value]));
                }
            }

        }
    }

    private static class Edge {

        int value;
        int cost;

        public Edge(int value, int cost) {
            this.value = value;
            this.cost = cost;
        }
    }
}