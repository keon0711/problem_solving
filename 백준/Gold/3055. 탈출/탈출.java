import java.util.*;

public class Main {

    static int N, M;
    static char[][] map;
    static int[][] waterSpread;
    static int[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        map = new char[N][M];
        waterSpread = new int[N][M];
        visited = new int[N][M];

        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> waterQueue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
                waterSpread[i][j] = -1;
                visited[i][j] = -1;

                if (map[i][j] == 'S') {
                    queue.add(new int[]{i, j});
                    visited[i][j] = 0;
                    map[i][j] = '.';
                }
                if (map[i][j] == '*') {
                    waterQueue.add(new int[]{i, j});
                    waterSpread[i][j] = 0;
                }
            }
        }

        while (!waterQueue.isEmpty()) {
            int[] poll = waterQueue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = poll[0] + dx[i];
                int ny = poll[1] + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == '.' && waterSpread[nx][ny] == -1) {
                    waterSpread[nx][ny] = waterSpread[poll[0]][poll[1]] + 1;
                    waterQueue.add(new int[]{nx, ny});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!(nx >= 0 && nx < N && ny >= 0 && ny < M)) {
                    continue;
                }

                if (map[nx][ny] == 'D') {
                    System.out.println(visited[x][y] + 1);
                    return;
                }

                if (map[nx][ny] != 'X' && visited[nx][ny] == -1 && (waterSpread[nx][ny] == -1 || waterSpread[nx][ny] > visited[x][y] + 1)) {
                    visited[nx][ny] = visited[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        System.out.println("KAKTUS");
    }
}
