import java.util.*;

public class Main {

    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        char[][] original = new char[N][N];
        char[][] blindness = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < N; j++) {
                char color = line.charAt(j);
                original[i][j] = color;
                blindness[i][j] = color == 'G' ? 'R' : color;
            }
        }

        int originalSections = 0;
        int blindnessSection = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (original[i][j] != 'X') {
                    bfs(original, i, j, original[i][j]);
                    originalSections++;
                }
                if (blindness[i][j] != 'X') {
                    bfs(blindness, i, j, blindness[i][j]);
                    blindnessSection++;
                }
            }
        }

        System.out.println(originalSections + " " + blindnessSection);
    }

    private static void bfs(char[][] picture, int i, int j, char color) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        picture[i][j] = 'X';

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[0];
            int y = poll[1];


            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && picture[nx][ny] != 'X' && picture[nx][ny] == color) {
                    picture[nx][ny] = 'X';
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
    }

}