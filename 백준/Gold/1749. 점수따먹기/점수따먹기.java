import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] a = new int[n + 1][m + 1];
        int[][] s = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j] = sc.nextInt();
                s[i][j] = a[i][j] + s[i - 1][j] + s[i][j - 1] - s[i - 1][j - 1];
            }
        }


        int max = -10000;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 0; k < i; k++) {
                    for (int l = 0; l < j; l++) {
                        max = Math.max(max, s[i][j] - s[k][j] - s[i][l] + s[k][l]);
                    }
                }
            }
        }

        System.out.println(max);
    }
}