import java.util.*;

public class Main {

    static int N, M, K;
    static int[][] map;
    static int[][] A;
    static List<int[]> trees = new ArrayList<>();
    static int[] dx = new int[]{-1, 0, 1, 0, -1, -1, 1, 1};
    static int[] dy = new int[]{0, 1, 0, -1, -1, 1, -1, 1};
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        map = new int[N][N];
        for (int[] row : map) {
            Arrays.fill(row, 5);
        }

        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            trees.add(new int[]{x - 1, y - 1, z});
        }

        for (int i = 0; i < K; i++) {
            simulate();
        }

        System.out.println(trees.size());
    }

    private static void simulate() {
        List<int[]> deadTrees = spring();
        summer(deadTrees);
        fall();
        winter();
    }

    private static List<int[]> spring() {
        List<int[]> aliveTrees = new ArrayList<>();
        List<int[]> deadTrees = new ArrayList<>();

        trees.sort(Comparator.comparingInt(t -> t[2]));
        for (int[] tree : trees) {
            int x = tree[0];
            int y = tree[1];
            int age = tree[2];

            if (map[x][y] < age) {
                deadTrees.add(tree);
            } else {
                map[x][y] -= age;
                tree[2]++;
                aliveTrees.add(tree);
            }
        }

        trees = aliveTrees;
        return deadTrees;
    }

    private static void summer(List<int[]> deadTrees) {
        for (int[] tree : deadTrees) {
            int x = tree[0];
            int y = tree[1];
            int age = tree[2];

            map[x][y] += age / 2;
        }
    }

    private static void fall() {
        List<int[]> newTrees = new ArrayList<>();

        for (int[] tree : trees) {
            int x = tree[0];
            int y = tree[1];
            int age = tree[2];

            if (age % 5 == 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                        newTrees.add(new int[]{nx, ny, 1});
                    }
                }
            }
        }

        trees.addAll(newTrees);
    }

    private static void winter() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] += A[i][j];
            }
        }
    }
}