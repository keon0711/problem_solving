import java.io.*;
import java.util.*;

public class Main {
    static int[] parent, candy, groupSize;
    static boolean[] visited;
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        candy = new int[N + 1];
        groupSize = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            candy[i] = Integer.parseInt(st.nextToken());
            groupSize[i] = 1;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        Map<Integer, Integer> groupCandy = new HashMap<>();
        Map<Integer, Integer> groupCount = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            int root = find(i);
            groupCandy.put(root, groupCandy.getOrDefault(root, 0) + candy[i]);
            groupCount.put(root, groupCount.getOrDefault(root, 0) + 1);
        }

        List<int[]> groups = new ArrayList<>();
        for (int key : groupCandy.keySet()) {
            groups.add(new int[]{groupCount.get(key), groupCandy.get(key)});
        }

        int[] dp = new int[K];
        for (int[] group : groups) {
            int size = group[0];
            int candies = group[1];
            for (int j = K - 1; j >= size; j--) {
                dp[j] = Math.max(dp[j], dp[j - size] + candies);
            }
        }

        int maxCandies = 0;
        for (int i = 0; i < K; i++) {
            maxCandies = Math.max(maxCandies, dp[i]);
        }

        System.out.println(maxCandies);
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }
}