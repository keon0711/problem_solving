import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    int[] plan;
    int[] group;

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
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        group = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            group[i] = i;
        }
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                if (Integer.parseInt(st.nextToken()) == 1)
                    union(i, j);
            }
        }

        plan = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            plan[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m - 1; i++) {
            if (!isUnion(plan[i], plan[i + 1])) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}