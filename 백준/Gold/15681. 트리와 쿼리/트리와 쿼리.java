import java.util.*;

public class Main {

    static int N, R, Q;
    static List<Integer>[] tree;
    static int[] subtreeSize;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();
        Q = sc.nextInt();

        tree = new List[N + 1];
        subtreeSize = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();

            tree[A].add(B);
            tree[B].add(A);
        }

        convertToTree(R, -1);

        for (int i = 0; i < Q; i++) {
            int root = sc.nextInt();
            System.out.println(subtreeSize[root]);
        }
    }


    private static int convertToTree(int node, int parent) {
        subtreeSize[node] = 1;

        for (int child : tree[node]) {
            if (child != parent) {
                subtreeSize[node] += convertToTree(child, node);
            }
        }

        return subtreeSize[node];
    }

}
