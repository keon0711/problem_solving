import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static List<Point> houses;
    static List<Point> originalRestaurants;
    static boolean[] open;
    static int minDist = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        houses = new ArrayList<>();
        originalRestaurants = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    originalRestaurants.add(new Point(i, j));
                }
                if (map[i][j] == 1) {
                    houses.add(new Point(i, j));
                }
            }
        }

        open = new boolean[originalRestaurants.size()];
        dfs(0, 0);
        System.out.println(minDist);

    }

    private static void dfs(int index, int cnt) {
        if (cnt == M) {
            int dist = calcChickenDist();
            minDist = Math.min(dist, minDist);
            return;
        }

        for (int i = index; i < originalRestaurants.size(); i++) {
            open[i] = true;
            dfs(i + 1, cnt + 1);
            open[i] = false;

        }
    }

    private static int calcChickenDist() {
        int dist = 0;
        for (Point house : houses) {
            int chickenDist = N * N;
            for (int i = 0; i < originalRestaurants.size(); i++) {
                if (open[i]) {
                    chickenDist = Math.min(chickenDist, house.calcDist(originalRestaurants.get(i)));
                }

            }
            dist += chickenDist;
        }
        return dist;
    }


    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int calcDist(Point p) {
            return Math.abs(this.x - p.x) + Math.abs(this.y - p.y);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}

