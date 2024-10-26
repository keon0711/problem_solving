import java.util.*;

public class Main {
    static int n, m, r;
    static int[] items;
    static List<List<Edge>> graph;
    static final int INF = 1_000_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();

        // 아이템 정보 입력
        items = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            items[i] = sc.nextInt();
        }

        // 그래프 초기화
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 입력
        for (int i = 0; i < r; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int l = sc.nextInt();

            graph.get(a).add(new Edge(b, l));
            graph.get(b).add(new Edge(a, l));
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, getItemCount(i));
        }

        System.out.println(result);
    }

    static int getItemCount(int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>((a, b) -> a.dist - b.dist);
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (cur.dist > dist[cur.to]) continue;

            for (Edge next : graph.get(cur.to)) {
                int nextDist = cur.dist + next.dist;
                if (nextDist < dist[next.to]) {
                    dist[next.to] = nextDist;
                    pq.offer(new Edge(next.to, nextDist));
                }
            }
        }

        // 수색 범위(m) 이내의 아이템 개수 계산
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] <= m) {
                count += items[i];
            }
        }

        return count;
    }

    static class Edge {
        int to, dist;

        Edge(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }

}

