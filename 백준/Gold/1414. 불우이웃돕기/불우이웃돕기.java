import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            if (weight > o.weight) {
                return 1;
            } else if (weight == o.weight) {
                return 0;
            } else {
                return -1;
            }
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    ", weight=" + weight +
                    '}';
        }
    }

    int[] group;

    public int convert(char c) {
        if ('a' <= c && c <= 'z') {
            return c - 'a' + 1;
        } else if ('A' <= c && c <= 'Z') {
            return c - 'A' + 27;
        }
        return 0;
    }

    public int findParents(int node) {
        if (node == group[node]) {
            return node;
        }
        group[node] = findParents(group[node]);
        return group[node];
    }

    public void union(int node1, int node2) {
        node1 = findParents(node1);
        node2 = findParents(node2);
        if (node1 == node2) {
            return;
        }
        group[node2] = node1;
    }

    public boolean isUnion(int node1, int node2) {
        return findParents(node1) == findParents(node2);
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        List<Edge> edges = new ArrayList<>();

        group = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            group[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 1; j <= N; j++) {
                int weight = convert(str.charAt(j - 1));
                if (weight == 0)
                    continue;
                edges.add(new Edge(i, j, weight));
            }
        }

        Collections.sort(edges);
        int totalWeight = 0;
        for (Edge edge : edges) {
            if (isUnion(edge.from, edge.to)) {
                totalWeight += edge.weight;
                continue;
            }
            union(edge.from, edge.to);
        }

        for (int i = 1; i < N; i++) {
            if (!isUnion(i, i+1)) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(totalWeight);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}