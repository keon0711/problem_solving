import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] stairs = new int[n + 1]; // 계단 점수
        int[] dp = new int[n + 1]; // dp 배열

        for (int i = 1; i <= n; i++) {
            stairs[i] = sc.nextInt();
        }

        // 초기값 설정
        dp[1] = stairs[1];
        if (n >= 2) {
            dp[2] = stairs[1] + stairs[2];
        }

        // 점화식 계산
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2] + stairs[i], dp[i - 3] + stairs[i - 1] + stairs[i]);
        }

        // 출력
        System.out.println(dp[n]);
    }
}