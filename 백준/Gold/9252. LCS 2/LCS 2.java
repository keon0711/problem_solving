import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        longestCommonSubsequence(str1, str2);
    }

    private static void longestCommonSubsequence(String str1, String str2) {
        int N = str1.length();
        int M = str2.length();
        int[][] dp = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (dp[N][M] > 0) {
            if (str1.charAt(N - 1) == str2.charAt(M - 1)) {
                sb.append(str1.charAt(N - 1));
                N--;
                M--;
            } else if (dp[N][M] == dp[N - 1][M]) {
                N--;
            } else {
                M--;
            }
        }

        System.out.println(sb.length());
        System.out.println(sb.reverse());

    }

}
