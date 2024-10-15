import java.util.*;

public class Main {
    static int N, M, D;
    static int[][] originalMap;
    static int maxKill = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        D = sc.nextInt();
        originalMap = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                originalMap[i][j] = sc.nextInt();
            }
        }

        combination(new int[3], 0, 0);
        System.out.println(maxKill);
    }

    static void combination(int[] archers, int index, int start) {
        if (index == 3) {
            simulate(archers);
            return;
        }

        for (int i = start; i < M; i++) {
            archers[index] = i;
            combination(archers, index + 1, i + 1);
        }
    }

    static void simulate(int[] archers) {
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = originalMap[i].clone();
        }

        int kill = 0;
        for (int turn = 0; turn < N; turn++) {
            List<int[]> targets = new ArrayList<>();
            for (int archer : archers) {
                int[] target = findNearestEnemy(map, N, archer);
                if (target != null) {
                    targets.add(target);
                }
            }

            for (int[] target : targets) {
                if (map[target[0]][target[1]] == 1) {
                    map[target[0]][target[1]] = 0;
                    kill++;
                }
            }

            moveEnemies(map);
        }

        maxKill = Math.max(maxKill, kill);
    }

    static int[] findNearestEnemy(int[][] map, int archerRow, int archerCol) {
        for (int d = 1; d <= D; d++) {
            for (int y = 0; y < M; y++) {  // 왼쪽부터 검사
                for (int x = N - 1; x >= 0; x--) {  // 아래에서 위로 검사
                    if (calculateDistance(x, y, archerRow, archerCol) == d && map[x][y] == 1) {
                        return new int[]{x, y};
                    }
                }
            }
        }
        return null;
    }

    static int calculateDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    static void moveEnemies(int[][] map) {
        for (int i = N - 1; i > 0; i--) {
            System.arraycopy(map[i - 1], 0, map[i], 0, M);
        }
        Arrays.fill(map[0], 0);
    }
}