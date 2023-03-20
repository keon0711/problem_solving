import java.util.*;
import java.util.stream.Collectors;

public class Main {
    int[][] arr;
    boolean[][] visited;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int n, m;

    public int bfs(int x, int y) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x, y});
        visited[x][y] = true;


        while (!que.isEmpty()) {
            int[] cur_pos = que.poll();
            if (cur_pos[0] == n && cur_pos[1] == m)
                return arr[cur_pos[0]][cur_pos[1]];

            for (int i = 0; i < 4; i++) {
                int next_x = cur_pos[0] + dx[i];
                int next_y = cur_pos[1] + dy[i];
                if (arr[next_x][next_y] != 0 && !visited[next_x][next_y]) {
                    arr[next_x][next_y] = arr[cur_pos[0]][cur_pos[1]] + 1;
                    que.add(new int[]{next_x, next_y});
                    visited[next_x][next_y] = true;
                }
            }
        }
        return -1;
    }

    public void solution() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n + 2][m + 2];
        visited = new boolean[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            String str = sc.next();
            for (int j = 1; j <= m; j++) {
                arr[i][j] =  str.charAt(j - 1) - '0';
            }
        }

        System.out.println(bfs(1, 1));
    }
    public static void main(String[] args) {
        new Main().solution();
    }
}