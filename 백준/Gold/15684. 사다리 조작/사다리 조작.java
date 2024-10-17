import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main {

    static int N, M, H;
    static int result = 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[H][N - 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a - 1][b - 1] = true;
        }



        dfs(map, 0);
        System.out.println(result > 3 ? -1 : result);
    }

    private static void dfs(boolean[][] map, int index) {

        if (index >= result) {
            return;
        }
        if (simulate(map)) {
            result = index;
            return;
        }
        if (index == 3) {
            return;
        }

        for (int row = 0; row < H; row++) {
            for (int col = 0; col < N - 1; col++) {
                if (map[row][col]) {
                    continue;
                }
                if ((col == 0 || !map[row][col - 1]) && (col == N - 2 || !map[row][col + 1])) {
                    map[row][col] = true;
                    dfs(map, index + 1);
                    map[row][col] = false;
                }

            }
        }

    }

    private static boolean simulate(boolean[][] map) {

        for (int col = 0; col < N; col++) {
            int currentCol = col;

            for (int row = 0; row < H; row++) {
                if (currentCol > 0 && map[row][currentCol - 1]) {
                    currentCol--;
                } else if (currentCol < N - 1 && map[row][currentCol]) {
                    currentCol++;
                }
            }

            if (currentCol != col) {
                return false;
            }
        }
        return true;
    }
}