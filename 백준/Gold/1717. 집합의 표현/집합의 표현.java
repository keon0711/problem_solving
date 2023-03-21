import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    int[] parent;

    public int findParents(int node) {
        if (node == parent[node]) {
            return node;
        }
        parent[node] = findParents(parent[node]);
        return parent[node];
    }

    public void union(int node1, int node2) {
        node1 = findParents(node1);
        node2 = findParents(node2);
        if (node1 == node2) {
            return;
        }
        parent[node2] = node1;
    }

    public void isUnion(int node1, int node2) {
        if (findParents(node1) == findParents(node2)) {
            System.out.println("YES");
            return;
        }
        System.out.println("NO");
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int func = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (func == 0) {
                union(a, b);
            }
            if (func == 1) {
                isUnion(a, b);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}