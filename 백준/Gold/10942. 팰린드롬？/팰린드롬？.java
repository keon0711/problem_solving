import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            dp[i][i] = 1;
        }

        for (int i = 0; i < N - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                dp[i][i + 1] = 1;
            }
        }

        for (int len = 3; len <= N; len++) {
            for (int i = 0; i <= N - len; i++) {
                int j = i + len - 1;
                if (arr[i] == arr[j] && dp[i + 1][j - 1] == 1) {
                    dp[i][j] = 1;
                }
            }
        }

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String[] split = br.readLine().split(" ");
            int S = Integer.parseInt(split[0]) - 1;
            int E = Integer.parseInt(split[1]) - 1;

            sb.append(dp[S][E]).append("\n");
        }
        System.out.println(sb);
    }
}
