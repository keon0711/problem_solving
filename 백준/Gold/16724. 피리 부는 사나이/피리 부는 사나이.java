import java.util.*;

public class Main {

    static boolean[][] visited;
    static boolean[][] finished;
    static int N;
    static int M;
    static int count = 0;
    private static String[] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        board = new String[N];
        visited = new boolean[N][M];
        finished = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = sc.next();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    dfs(i, j);
                }
            }
        }

        System.out.println(count);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        int[] nextPos = next(x, y);
        int nx = nextPos[0];
        int ny = nextPos[1];

        if (!visited[nx][ny]) {
            dfs(nx, ny);
        } else if (!finished[nx][ny]) {
            count++;
        }

        finished[x][y] = true;
    }

    public static int[] next(int x, int y) {
        char direction = board[x].charAt(y);

        return switch (direction) {
            case 'L' -> new int[]{x, y - 1};
            case 'R' -> new int[]{x, y + 1};
            case 'U' -> new int[]{x - 1, y};
            case 'D' -> new int[]{x + 1, y};
            default -> null;
        };
    }

}