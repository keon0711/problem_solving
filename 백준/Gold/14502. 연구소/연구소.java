import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Main {
    static int[][] map;
    static int N;
    static int M;
    static int maxSafeArea = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        dfs(0);
        System.out.println(maxSafeArea);
        }

    private static void dfs(int wallCount) {
        if (wallCount == 3) {
            spread();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(wallCount + 1);
                    map[i][j] = 0;

                }
            }
        }
    }

    private static void spread() {
        Queue<int[]> q = new LinkedList<>();
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        int[][] copiedMap = new int[N][];
        for (int i = 0; i < N; i++) {
            copiedMap[i] = map[i].clone();
        }

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && copiedMap[nx][ny] == 0) {
                    copiedMap[nx][ny] = 2;
                    q.add(new int[]{nx, ny});
                }

            }
        }

        countSafeArea(copiedMap);
    }

    private static void countSafeArea(int[][] copiedMap) {
        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copiedMap[i][j] == 0) {
                    result++;
                }
            }
        }

        maxSafeArea = Integer.max(maxSafeArea, result);
    }


}