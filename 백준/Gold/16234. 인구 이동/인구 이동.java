import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    
    static int N;
    static int L;
    static int R;
    static int[][] map;
    static boolean[][] visited;
    static List<int[]> allies;
    static int days = 0;
    static int numberOfCountries = 0;
    static int totalPopulation = 0;
    static boolean flag = true;

    public static void main(String[] args) throws IOException {
        init();

        while (flag) {
            flag = false;
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        totalPopulation = 0;
                        numberOfCountries = 0;
                        allies = new ArrayList<>();
                        visited[i][j] = true;
                        formAlliance(i, j);
                        updatePopulation();
                    }
                }
            }
            days++;
        }
        System.out.println(--days);
    }

    private static void updatePopulation() {
        if (numberOfCountries < 2) {
            return;
        }

        int population = totalPopulation / numberOfCountries;
        for (int[] ally : allies) {
            map[ally[0]][ally[1]] = population;
            flag = true;
        }
    }

    private static void formAlliance(int x, int y) {
        totalPopulation += map[x][y];
        numberOfCountries++;
        allies.add(new int[]{x, y});

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isInMap(nx, ny) && !visited[nx][ny] && isInRange(x, y, nx, ny)) {
                visited[nx][ny] = true;
                formAlliance(nx, ny);
            }
        }
    }

    private static boolean isInRange(int x, int y, int nx, int ny) {
        int gap = Math.abs(map[x][y] - map[nx][ny]);
        return gap >= L && gap <= R;
    }

    private static boolean isInMap(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}