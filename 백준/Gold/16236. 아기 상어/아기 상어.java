import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int[] numberOfFishes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        numberOfFishes = new int[7];
        Shark shark = new Shark();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
                if (value > 0 && value < 7)
                    numberOfFishes[value]++;
                if (value == 9) {
                    shark.setPos(i, j);
                    map[i][j] = 0;
                }
            }
        }
        shark.countEatableFishes();

        while (shark.eatableFishes > 0 && shark.move()) {}
        
        System.out.println(shark.time);
    }


    static class Shark {
        final static int[] dx = {-1, 0, 0, 1};
        final static int[] dy = {0, -1, 1, 0};

        public int x;
        public int y;
        public int size = 2;
        public int numberOfFish = 0;
        public int time = 0;
        public int eatableFishes = 0;

        public void countEatableFishes() {
            for (int i = 1; i < size; i++) {
                eatableFishes += numberOfFishes[i];
            }
        }

        public boolean move() {
            Queue<int[]> q = new PriorityQueue<>((a, b) -> {
                if (a[2] == b[2]) {
                    if (a[0] == b[0]) {
                        return a[1] - b[1];
                    }
                    return a[0] - b[0];
                }
                return a[2] - b[2];
            });
            q.add(new int[]{x, y, 0});
            boolean[][] visited = new boolean[N][N];
            visited[x][y] = true;

            while (!q.isEmpty()) {
                int[] poll = q.poll();
                int curX = poll[0];
                int curY = poll[1];
                int curTime = poll[2];
                if (map[curX][curY] != 0 && map[curX][curY] < size) {
                    time += curTime;
                    x = curX;
                    y = curY;
                    eat(x, y);

                    return true;
                }
                for (int i = 0; i < 4; i++) {
                    int nx = curX + dx[i];
                    int ny = curY + dy[i];

                    if (isInRange(nx, ny) && isMovable(nx, ny) && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny, curTime + 1});
                    }
                }
            }

            return false;
        }

        private void eat(int x, int y) {
            int fish = map[x][y];
            numberOfFishes[fish]--;
            eatableFishes--;
            map[x][y] = 0;
            if (++numberOfFish == size) {
                if (size < 7) {
                    eatableFishes += numberOfFishes[size];
                }
                size++;
                numberOfFish = 0;
            }
        }

        private boolean isMovable(int nx, int ny) {
            if (size >= map[nx][ny]) {
                return true;
            }
            return false;
        }

        public void setPos(int i, int j) {
            this.x = i;
            this.y = j;
        }

        private boolean isInRange(int x, int y) {
            return (x >= 0 && x < N && y >= 0 && y < N);
        }
    }
}
