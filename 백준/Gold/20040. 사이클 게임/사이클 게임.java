import java.util.Scanner;

public class Main {

    private static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        int n = sc.nextInt();
        int m = sc.nextInt();

        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if (find(a) == find(b)) {
                result = i + 1;
                break;
            }
            union(a, b);
        }

        System.out.println(result);
    }

    private static int find(int a) {
        if (parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);

    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) {
            return;
        }
        parent[b] = a;
    }
}