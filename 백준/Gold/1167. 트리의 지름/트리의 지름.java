import java.util.*;

public class Main {
    static Map<Integer, List<Node>> tree = new HashMap<>();
    static boolean[] visited;
    static int maxDist = 0;
    static int farthestNode = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();

        for (int i = 0; i < V; i++) {
            int node = sc.nextInt();

            while (true) {
                int adjNode = sc.nextInt();
                if (adjNode == -1) break;
                int dist = sc.nextInt();

                connect(node, adjNode, dist);
                connect(adjNode, node, dist);
            }
        }

        visited = new boolean[V + 1];
        dfs(1, 0);

        visited = new boolean[V + 1];
        dfs(farthestNode, 0);

        System.out.println(maxDist);
    }

    private static void connect(int node, int adjNode, int dist) {
        tree.computeIfAbsent(node, k -> new ArrayList<>()).add(new Node(adjNode, dist));
    }

    private static void dfs(int node, int dist) {
        visited[node] = true;
        
        if (dist > maxDist) {
            maxDist = dist;
            farthestNode = node;
        }

        for (Node adj : tree.get(node)) {
            if (!visited[adj.value]) {
                dfs(adj.value, dist + adj.dist);
            }
        }
    }

    // 노드와 거리를 나타내는 클래스
    static class Node {
        int value;
        int dist;

        Node(int value, int dist) {
            this.value = value;
            this.dist = dist;
        }
    }
}