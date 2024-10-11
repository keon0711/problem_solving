import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int N, M, T;
    static int[][] map;

    static int[]dx = new int[]{-1, 0, 0, 1};
    static int[] dy = new int[]{0, -1, 1, 0};
    static List<int[]> circulator = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        T = sc.nextInt();

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == -1) {
                    circulator.add(new int[]{i, j});
                }
            }
        }

        for (int i = 0; i < T; i++) {
            spread();
            circulate();
        }

        // 최종 결과 출력
        System.out.println(totalDust());
    }

    // 미세먼지 확산
    private static void spread() {
        int[][] nextMap = new int[N][M];

        // 기존 맵을 복사
        for (int i = 0; i < N; i++) {
            nextMap[i] = Arrays.copyOf(map[i], M);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    int spreadingAmount = map[i][j] / 5;
                    int spreadCount = 0;

                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if (nx < 0 || nx >= N || ny < 0 || ny >= M || map[nx][ny] == -1) {
                            continue;
                        }

                        nextMap[nx][ny] += spreadingAmount;
                        spreadCount++;
                    }

                    nextMap[i][j] -= spreadingAmount * spreadCount;
                }
            }
        }

        map = nextMap;
    }

    // 공기 청정기 작동
    private static void circulate() {
        int upper = circulator.get(0)[0]; // 공기청정기 상단
        int lower = circulator.get(1)[0]; // 공기청정기 하단

        // 상단 공기청정기 (반시계 방향)
        for (int i = upper - 1; i > 0; i--) map[i][0] = map[i - 1][0];
        for (int i = 0; i < M - 1; i++) map[0][i] = map[0][i + 1];
        for (int i = 0; i < upper; i++) map[i][M - 1] = map[i + 1][M - 1];
        for (int i = M - 1; i > 1; i--) map[upper][i] = map[upper][i - 1];
        map[upper][1] = 0;

        // 하단 공기청정기 (시계 방향)
        for (int i = lower + 1; i < N - 1; i++) map[i][0] = map[i + 1][0];
        for (int i = 0; i < M - 1; i++) map[N - 1][i] = map[N - 1][i + 1];
        for (int i = N - 1; i > lower; i--) map[i][M - 1] = map[i - 1][M - 1];
        for (int i = M - 1; i > 1; i--) map[lower][i] = map[lower][i - 1];
        map[lower][1] = 0;
    }

    // 전체 미세먼지 양 계산
    private static int totalDust() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    sum += map[i][j];
                }
            }
        }
        return sum;
    }
}