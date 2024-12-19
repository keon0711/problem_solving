import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    private static List<Fireball>[][] map;
    private static int N, M, K;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        map = new List[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            int m = sc.nextInt();
            int s = sc.nextInt();
            int d = sc.nextInt();
            map[r][c].add(new Fireball(m, s, d));
        }

        for (int i = 0; i < K; i++) {
            move();
            mergeAndSplit();
        }

        int totalMass = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (Fireball fireball : map[i][j]) {
                    totalMass += fireball.mass;
                }
            }
        }

        System.out.println(totalMass);
    }

    private static void move() {
        List<Fireball>[][] temp = new List[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                temp[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (Fireball fireball : map[i][j]) {
                    int r = (i + dr[fireball.direction] * fireball.speed % N + N) % N;
                    int c = (j + dc[fireball.direction] * fireball.speed % N + N) % N;
                    temp[r][c].add(new Fireball(fireball.mass, fireball.speed, fireball.direction));
                }
            }
        }
        map = temp;
    }

    private static void mergeAndSplit() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j].size() < 2) continue;

                int massSum = 0, speedSum = 0;
                boolean allEven = true, allOdd = true;
                int count = map[i][j].size();

                for (Fireball fireball : map[i][j]) {
                    massSum += fireball.mass;
                    speedSum += fireball.speed;
                    if (fireball.direction % 2 == 0) {
                        allOdd = false;
                    } else {
                        allEven = false;
                    }
                }

                int newMass = massSum / 5;
                if (newMass == 0) {
                    map[i][j].clear();
                    continue;
                }

                int newSpeed = speedSum / count;
                map[i][j].clear();

                int[] newDirections = allEven || allOdd ? new int[]{0, 2, 4, 6} : new int[]{1, 3, 5, 7};
                for (int dir : newDirections) {
                    map[i][j].add(new Fireball(newMass, newSpeed, dir));
                }
            }
        }
    }

    static class Fireball {
        int mass;
        int speed;
        int direction;

        public Fireball(int mass, int speed, int direction) {
            this.mass = mass;
            this.speed = speed;
            this.direction = direction;
        }
    }
}