import java.io.*;
import java.util.*;

public class Main {

    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N][N];

        // 중앙(mid)를 기준으로 팰린드롬 계산
        for (int mid = 0; mid < N; mid++) {
            // 홀수 길이 팰린드롬 (중앙이 mid)
            int left = mid;
            int right = mid;
            while (left >= 0 && right < N && arr[left] == arr[right]) {
                dp[left][right] = 1;
                left--;
                right++;
            }

            // 짝수 길이 팰린드롬 (중앙이 mid, mid+1)
            left = mid;
            right = mid + 1;
            while (left >= 0 && right < N && arr[left] == arr[right]) {
                dp[left][right] = 1;
                left--;
                right++;
            }
        }

        // 질의 처리
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer query = new StringTokenizer(br.readLine(), " ");
            int S = Integer.parseInt(query.nextToken()) - 1;
            int E = Integer.parseInt(query.nextToken()) - 1;

            // 결과를 StringBuilder에 추가
            sb.append(dp[S][E]).append("\n");
        }

        // 최종 결과 출력
        System.out.print(sb.toString());
    }
}