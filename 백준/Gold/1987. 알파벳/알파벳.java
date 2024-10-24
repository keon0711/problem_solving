import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    static char[][] map;
    static int result = 0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    private static int R;
    private static int C;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine();

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        Set<Character> path = new HashSet<>();
        path.add(map[0][0]);
        dfs(0, 0, path);

        System.out.println(result);
    }

    private static void dfs(int x, int y, Set<Character> path) {
        result = Math.max(result, path.size());

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < R && ny >= 0 && ny < C && !path.contains(map[nx][ny])) {
                path.add(map[nx][ny]);
                dfs(nx, ny, path);
                path.remove(map[nx][ny]);
            }
        }
    }

}