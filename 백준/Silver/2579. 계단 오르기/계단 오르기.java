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

        // DP 배열 초기화 (-1로 설정)
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }

        // 출력 (n번째 계단까지의 최대 점수)
        System.out.println(dfs(n));
    }

    private static int dfs(int step) {
        // 기저 조건
        if (step <= 0) {
            return 0;
        }

        if (step == 1) {
            return stairs[1];
        }

        if (step == 2) {
            return stairs[1] + stairs[2];
        }

        if (step == 3) {
            return Math.max(stairs[1] + stairs[3], stairs[2] + stairs[3]);
        }

        // 메모이제이션: 이미 계산된 값이면 반환
        if (dp[step] != -1) {
            return dp[step];
        }

        // 점화식 계산
        dp[step] = Math.max(
            dfs(step - 2) + stairs[step], 
            dfs(step - 3) + stairs[step - 1] + stairs[step]
        );

        return dp[step];
    }
}