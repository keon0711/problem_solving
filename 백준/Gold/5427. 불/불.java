import java.util.*;

public class Main {
    static int T, R, C;
    static char[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Point> queue = new LinkedList<>();
    static Queue<Point> fireQueue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();

        while (T-- > 0){
            C = sc.nextInt();
            R = sc.nextInt();
            sc.nextLine();
            map = new char[R][C];
            queue.clear();
            fireQueue.clear();

            for (int i = 0; i < R; i++) {
                String line = sc.next();
                for (int j = 0; j < C; j++) {
                    map[i][j] = line.charAt(j);
                    if (map[i][j] == '@') {
                        queue.add(new Point(i, j, 0));
                    } else if (map[i][j] == '*') {
                        fireQueue.add(new Point(i, j));
                    }
                }
            }

            int result = bfs();
            System.out.println(result == -1 ? "IMPOSSIBLE" : result);
        }
    }

    private static int bfs() {
        while (!queue.isEmpty()) {
            int fireSize = fireQueue.size();
            for (int i = 0; i < fireSize; i++) {
                Point cur = fireQueue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];

                    if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                        continue;
                    }
                    if (map[nx][ny] == '.' || map[nx][ny] == '@') {
                        map[nx][ny] = '*';
                        fireQueue.add(new Point(nx, ny));
                    }
                }
            }

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point cur = queue.poll();
                if (cur.x == 0 || cur.x == R - 1 || cur.y == 0 || cur.y == C - 1) {
                    return cur.time + 1;
                }

                for (int j = 0; j < 4; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];

                    if (map[nx][ny] == '.') {
                        map[nx][ny] = '@';
                        queue.add(new Point(nx, ny, cur.time + 1));
                    }
                }
            }

        }

        return -1;
    }

    static class Point {
        int x, y, time;

        Point(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        Point(int x, int y) {
            this(x, y, 0);
        }
    }

}
