import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n + 6];
        Arrays.fill(dp, 50000);
        dp[3] = 1;
        dp[5] = 1;

        for (int i = 3; i < n + 1; i++) {
            if (dp[i] < 50000) {
                dp[i + 3] = (dp[i + 3] > dp[i] + 1) ? dp[i] + 1 : dp[i + 3];
                dp[i + 5] = (dp[i + 5] > dp[i] + 1) ? dp[i] + 1 : dp[i + 5];
            }
        }

        if (dp[n] == 50000) {
            System.out.println(-1);
        } else {
            System.out.println(dp[n]);
        }
    }
}