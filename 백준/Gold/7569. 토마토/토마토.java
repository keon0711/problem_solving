import java.util.*;

public class Main {

    private static int N, M, H;
    private static int[] dm = {1, -1, 0, 0, 0, 0};
    private static int[] dn = {0, 0, 1, -1, 0, 0};
    private static int[] dh = {0, 0, 0, 0, 1, -1};
    private static int totalTomatoes;
    private static int ripeTomatoes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();

        int[][][] tomatoes = new int[M][N][H];
        Queue<int[]> queue = new LinkedList<>();

        totalTomatoes = 0;
        ripeTomatoes = 0;

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    tomatoes[m][n][h] = sc.nextInt();
                    if (tomatoes[m][n][h] == 1) {
                        queue.add(new int[]{m, n, h});
                        ripeTomatoes++;
                    }
                    if (tomatoes[m][n][h] != -1) {
                        totalTomatoes++;
                    }
                }
            }
        }

        // 이미 모든 토마토가 익었을 경우
        if (ripeTomatoes == totalTomatoes) {
            System.out.println(0);
            return;
        }

        int days = bfs(tomatoes, queue);

        // 모든 토마토가 익었는지 확인
        if (ripeTomatoes == totalTomatoes) {
            System.out.println(days);
        } else {
            System.out.println(-1);
        }
    }

    private static int bfs(int[][][] tomatoes, Queue<int[]> queue) {
        int days = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            days++;

            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int m = current[0];
                int n = current[1];
                int h = current[2];

                for (int d = 0; d < 6; d++) {
                    int nm = m + dm[d];
                    int nn = n + dn[d];
                    int nh = h + dh[d];

                    if (nm >= 0 && nm < M && nn >= 0 && nn < N && nh >= 0 && nh < H && tomatoes[nm][nn][nh] == 0) {
                        ripeTomatoes++;
                        tomatoes[nm][nn][nh] = 1;
                        queue.add(new int[]{nm, nn, nh});
                    }
                }
            }
        }

        return days;
    }
}