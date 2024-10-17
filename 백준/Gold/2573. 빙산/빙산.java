import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main {

    private static int N;
    private static int M;
    static int[][] map;
    static int[] dx = new int[]{-1, 0, 0, 1};
    static int[] dy = new int[]{-0, -1, 1, 0};

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

        int years = 0;
        while (true) {
            int count = countIcebergs();
            if (count == 0) {
                years = 0;
                break;
            }
            if (count >= 2) {
                break;
            }

            melt();
            years++;
        }

        System.out.println(years);
    }

    private static int countIcebergs() {
        int count = 0;
        boolean[][] visited = new boolean[N][M];

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (map[x][y] > 0 && !visited[x][y]) {
                    count++;
                    bfs(x, y, visited);
                }
            }
        }
        return count;
    }

    private static void bfs(int x, int y, boolean[][] visited) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x, y});
        visited[x][y] = true;

        while (!que.isEmpty()) {
            int[] poll = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] > 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    que.add(new int[]{nx, ny});
                }
            }
        }
    }

    private static void melt() {
        int[][] nextMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            nextMap[i] = map[i].clone();
        }

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < M; y++) {
                if (map[x][y] == 0) {
                    continue;
                }
                for (int k = 0; k < 4; k++) {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
                        nextMap[x][y] -= 1;
                        nextMap[x][y] = Math.max(0, nextMap[x][y]);
                    }
                }
            }
        }

        map = nextMap;
    }
}