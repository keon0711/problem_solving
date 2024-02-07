import java.util.Scanner;

public class Main {

    static int k = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dfs(1, 2, 3, n);
        System.out.println(k);
        System.out.println(sb);
    }

    public static void dfs(int start, int mid, int end, int n) {
        if (n == 1) {
            k++;
            sb.append(start + " " + end + "\n");
            return;
        }
        dfs(start, end, mid, n - 1);
        dfs(start, mid, end, 1);
        dfs(mid, start, end, n - 1);
    }
}
