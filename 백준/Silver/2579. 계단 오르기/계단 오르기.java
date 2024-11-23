import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static int[] stairs;
    private static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        stairs = new int[n + 1];
        dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            stairs[i] = sc.nextInt();
        }

        if (n == 1) {
            System.out.println(stairs[1]);
            return;
        }

        Arrays.fill(dp, -1);
        dp[1] = stairs[1];
        dp[2] = stairs[1] + stairs[2];

        System.out.println(maxScore(n));
    }

    private static int maxScore(int step) {

        if (step <= 0) {
            return 0;
        }
        if (dp[step] != -1) {
            return dp[step];
        }

        dp[step] = Math.max(
            maxScore(step - 2) + stairs[step],
            maxScore(step - 3) + stairs[step - 1] + stairs[step]
        );

        return dp[step];
    }
}