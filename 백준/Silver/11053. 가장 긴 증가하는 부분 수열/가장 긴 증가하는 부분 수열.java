import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 수열의 길이 입력
        int[] arr = new int[n];  // 수열을 저장할 배열
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();  // 수열 입력
        }
        
        int[] dp = new int[n];  // dp[i]는 arr[i]를 끝으로 하는 LIS의 길이
        for (int i = 0; i < n; i++) {
            dp[i] = 1;  // 최소 길이는 자기 자신만 포함하므로 1로 초기화
        }
        
        int maxLength = 1;  // LIS의 최종 길이를 저장할 변수
        
        // DP 배열 갱신
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {  // 현재 숫자가 이전 숫자보다 크다면
                    dp[i] = Math.max(dp[i], dp[j] + 1);  // dp[i] 갱신
                }
            }
            maxLength = Math.max(maxLength, dp[i]);  // 최종 결과 갱신
        }
        
        System.out.println(maxLength);  // 가장 긴 증가하는 부분 수열의 길이 출력
    }
}