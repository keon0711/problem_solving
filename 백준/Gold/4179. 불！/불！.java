import java.util.*;

public class Main {

    static int rows, cols;
    static char[][] maze;
    static int[][] fireSpread;
    static int[][] jihoonVisited;
    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        rows = scanner.nextInt();
        cols = scanner.nextInt();
        maze = new char[rows][cols];
        fireSpread = new int[rows][cols];
        jihoonVisited = new int[rows][cols];
        
        Queue<int[]> fireQueue = new LinkedList<>();
        Queue<int[]> jihoonQueue = new LinkedList<>();

        for (int i = 0; i < rows; i++) {
            String line = scanner.next();
            for (int j = 0; j < cols; j++) {
                maze[i][j] = line.charAt(j);
                fireSpread[i][j] = -1;
                jihoonVisited[i][j] = -1;
                if (maze[i][j] == 'F') {
                    fireQueue.add(new int[]{i, j});
                    fireSpread[i][j] = 0;
                }
                if (maze[i][j] == 'J') {
                    jihoonQueue.add(new int[]{i, j});
                    jihoonVisited[i][j] = 0;
                }
            }
        }

        // Spread fire in the maze
        while (!fireQueue.isEmpty()) {
            int[] current = fireQueue.poll();
            int r = current[0];
            int c = current[1];
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dRow[i];
                int nc = c + dCol[i];
                
                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && maze[nr][nc] != '#' && fireSpread[nr][nc] == -1) {
                    fireSpread[nr][nc] = fireSpread[r][c] + 1;
                    fireQueue.add(new int[]{nr, nc});
                }
            }
        }

        // Escape using Jihoon's movement
        while (!jihoonQueue.isEmpty()) {
            int[] current = jihoonQueue.poll();
            int r = current[0];
            int c = current[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dRow[i];
                int nc = c + dCol[i];

                // Check if out of bounds (escape condition)
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
                    System.out.println(jihoonVisited[r][c] + 1);
                    return;
                }

                if (maze[nr][nc] == '.' && jihoonVisited[nr][nc] == -1) {
                    if (fireSpread[nr][nc] == -1 || jihoonVisited[r][c] + 1 < fireSpread[nr][nc]) {
                        jihoonVisited[nr][nc] = jihoonVisited[r][c] + 1;
                        jihoonQueue.add(new int[]{nr, nc});
                    }
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}
