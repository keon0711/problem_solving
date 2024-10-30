import java.util.*;

public class Main {

    private static final int OUTER_AIR = -1;
    private static final int INNER_AIR = 0;
    private static final int CHEESE = 1;
    private static final int MELTING_CHEESE = 2;

    private static int N, M;
    private static int[][] map;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int time = 0;
        while (true) {
            checkOuterAir();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] == CHEESE && canMelt(i, j)) {
                        map[i][j] = MELTING_CHEESE;
                    }
                }
            }
            int meltedCheese = removeCheese();
            if (meltedCheese == 0) {
                break;
            }
            time++;
        }

        System.out.println(time);
    }

    private static int removeCheese() {
        int meltedCheese = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == MELTING_CHEESE) {
                    map[i][j] = INNER_AIR;
                    meltedCheese++;
                }
            }
        }

        return meltedCheese;
    }

    private static boolean canMelt(int x, int y) {
        int adjacentAir = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == OUTER_AIR) {
                adjacentAir++;
            }
        }
        return adjacentAir >= 2;
    }

    private static void checkOuterAir() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        map[0][0] = OUTER_AIR;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && isAir(nx, ny) && !visited[nx][ny]) {
                    map[nx][ny] = OUTER_AIR;
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }

    private static boolean isAir(int nx, int ny) {
        return map[nx][ny] == INNER_AIR || map[nx][ny] == OUTER_AIR;
    }

}

