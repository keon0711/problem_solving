import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final int INF = 10000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        int[][] graph = new int[V + 1][V + 1];
        for (int i = 0; i < V + 1; i++) {
            Arrays.fill(graph[i], INF);
        }

        for (int i = 0; i < E; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();

            graph[from][to] = weight;
        }



        for (int k = 1; k < V + 1; k++) {
            for (int i = 1; i < V + 1; i++) {
                for (int j = 1; j < V + 1; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }

//        for (int i = 0; i < V + 1; i++) {
//            System.out.println(Arrays.toString(graph[i]));
//        }

        int minDist = INF;
        for (int i = 1; i < V + 1; i++) {
            if (minDist > graph[i][i]) {
                minDist = graph[i][i];
            }
        }

        if (minDist == INF) {
            System.out.println(-1);
        } else {
            System.out.println(minDist);
        }
    }
}