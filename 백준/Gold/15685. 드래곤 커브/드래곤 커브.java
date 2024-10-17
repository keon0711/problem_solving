import java.util.*;
import java.io.*;

public class Main {
    static boolean[][] grid = new boolean[101][101];
    static int[] dx = {1, 0, -1, 0}; // 0: 오른쪽, 1: 위, 2: 왼쪽, 3: 아래
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // 시작 x 좌표
            int y = Integer.parseInt(st.nextToken()); // 시작 y 좌표
            int d = Integer.parseInt(st.nextToken()); // 시작 방향
            int g = Integer.parseInt(st.nextToken()); // 세대

            List<Integer> directions = new ArrayList<>();
            directions.add(d);
            generateDirections(directions, g);

            grid[x][y] = true;
            for(int dir : directions){
                x += dx[dir];
                y += dy[dir];
                if(x >= 0 && x <= 100 && y >= 0 && y <= 100){
                    grid[x][y] = true;
                }
            }
        }

        // 네 꼭짓점이 모두 드래곤 커브의 일부인 정사각형 개수 세기
        int count = 0;
        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                if(grid[i][j] && grid[i+1][j] && grid[i][j+1] && grid[i+1][j+1]){
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    // 재귀적으로 방향 정보를 생성하는 함수
    public static void generateDirections(List<Integer> directions, int generation){
        if(generation == 0){
            return;
        }

        int size = directions.size();
        for(int i = size - 1; i >= 0; i--){
            int dir = (directions.get(i) + 1) % 4;
            directions.add(dir);
        }

        generateDirections(directions, generation - 1);
    }
}