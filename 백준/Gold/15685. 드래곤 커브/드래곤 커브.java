import java.util.*;

public class Main {

    static int[] dx = new int[]{1, 0, -1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    static int[][] map = new int[101][101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int d = sc.nextInt();
            int g = sc.nextInt();

            dragonCurve(x, y, d, g);
        }

        System.out.println(countSquare());
    }

    private static int countSquare() {
        int squareCount = 0;

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] == 1 && map[i + 1][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j + 1] == 1) {
                    squareCount++;
                }
            }
        }

        return squareCount;
    }

    private static void dragonCurve(int x, int y, int d, int g) {
        List<Integer> directions = new ArrayList<>();
        directions.add(d);

        map[y][x] = 1;
        x += dx[d];
        y += dy[d];
        map[y][x] = 1;

        for (int i = 0; i < g; i++) {
            int size = directions.size();
            for (int j = size - 1; j >= 0; j--) {
                d = (directions.get(j) + 1) % 4;
                x += dx[d];
                y += dy[d];
                map[y][x] = 1;
                directions.add(d);
            }
        }
    }
}