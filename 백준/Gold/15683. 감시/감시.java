import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    // 상 우 하 좌
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];

        // x, y, 종류, 방향
        List<int[]> cctvs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int n = sc.nextInt();
                map[i][j] = n;
                if (n >= 1 && n <= 5) {
                    cctvs.add(new int[]{i, j, n, 0});
                }
            }
        }

        dfs(cctvs, 0);
        System.out.println(result);
    }

    static void dfs(List<int[]> cctvs, int index) {
        if (index == cctvs.size()) {
            simulate(cctvs);
            return;
        }

        int[] cctv = cctvs.get(index);

        if (cctv[2] == 5) {
            dfs(cctvs, index + 1);
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            cctv[3] = dir;
            dfs(cctvs, index + 1);
        }
    }

    private static void simulate(List<int[]> cctvs) {
        int[][] tempMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            tempMap[i] = map[i].clone();
        }

        for (int[] cctv : cctvs) {
            int x = cctv[0];
            int y = cctv[1];
            int type = cctv[2];
            int dir = cctv[3];

            switch (type) {
                case 1:
                    watch(x, y, dir, tempMap);
                    break;

                case 2:
                    watch(x, y, dir, tempMap);
                    watch(x, y, (dir + 2) % 4, tempMap);
                    break;

                case 3:
                    watch(x, y, dir, tempMap);
                    watch(x, y, (dir + 1) % 4, tempMap);
                    break;

                case 4:
                    watch(x, y, dir, tempMap);
                    watch(x, y, (dir + 1) % 4, tempMap);
                    watch(x, y, (dir + 2) % 4, tempMap);
                    break;

                case 5:
                    watch(x, y, dir, tempMap);
                    watch(x, y, (dir + 1) % 4, tempMap);
                    watch(x, y, (dir + 2) % 4, tempMap);
                    watch(x, y, (dir + 3) % 4, tempMap);
                    break;
            }
        }

        int blindSpots = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempMap[i][j] == 0) {
                    blindSpots++;
                }
            }
        }

        result = Math.min(result, blindSpots);
    }

    private static void watch(int x, int y, int direction, int[][] map) {
        int nx = x;
        int ny = y;

        while (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] != 6) {

            if (map[nx][ny] == 0) {
                map[nx][ny] = -1;
            }

            nx += dx[direction];
            ny += dy[direction];
        }
    }
}