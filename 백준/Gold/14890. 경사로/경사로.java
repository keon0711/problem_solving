import java.util.Scanner;

public class Main {

    static int N, L;
    static int[][] map;
    static boolean[] slope;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        L = sc.nextInt();

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int count = 0;

        for (int i = 0; i < N; i++) {
            if (canInstallSlope(map[i])) {
                count++;
            }
        }

        for (int i = 0; i < N; i++) {
            int[] col = new int[N];
            for (int j = 0; j < N; j++) {
                col[j] = map[j][i];
            }
            if (canInstallSlope(col)) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean canInstallSlope(int[] line) {
        slope = new boolean[N];

        for (int i = 0; i < N - 1; i++) {
            // 높이가 동일한 경우
            if (line[i] == line[i + 1]) {
                continue;

            // 낮아지는 경우
            } else if (line[i] - line[i + 1] == 1) {
                for (int j = i + 1; j <= i + L; j++) {
                    if (j >= N || line[j] != line[i + 1] || slope[j]) {
                        return false;
                    }
                    slope[j] = true;
                }

            // 높아지는 경우
            } else if (line[i] - line[i + 1] == - 1) {
                for (int j = i; j > i - L; j--) {
                    if (j < 0 || line[j] != line[i] || slope[j]) {
                        return false;
                    }
                    slope[j] = true;
                }

            // 높이 차가 1보다 큰 경우
            } else {
                return false;
            }

        }

        return true;
    }
}