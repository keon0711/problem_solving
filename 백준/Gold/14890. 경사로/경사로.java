import java.util.*;

public class Main {
    static int N, L;
    static int[][] map;
    static boolean[] slope;

    // 경사로 설치가 가능한지 확인
    static boolean canInstallSlope(int[] road) {
        slope = new boolean[N]; // 경사로 설치 여부 체크
        for (int i = 0; i < N - 1; i++) {
            if (road[i] == road[i + 1]) continue; // 높이가 같으면 넘어감

            // 높이 차이가 1 이상이면 경사로 설치 불가
            if (Math.abs(road[i] - road[i + 1]) > 1) return false;

            // 현재 높이가 다음 높이보다 큰 경우 (경사로 아래쪽으로 설치)
            if (road[i] > road[i + 1]) {
                for (int j = i + 1; j <= i + L; j++) {
                    if (j >= N || road[j] != road[i + 1] || slope[j]) return false;
                    slope[j] = true; // 경사로 설치
                }
            }
            // 현재 높이가 다음 높이보다 작은 경우 (경사로 위쪽으로 설치)
            else {
                for (int j = i; j > i - L; j--) {
                    if (j < 0 || road[j] != road[i] || slope[j]) return false;
                    slope[j] = true; // 경사로 설치
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextInt();
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int count = 0;

        // 가로 도로 검사
        for (int i = 0; i < N; i++) {
            if (canInstallSlope(map[i])) count++;
        }

        // 세로 도로 검사
        for (int i = 0; i < N; i++) {
            int[] road = new int[N];
            for (int j = 0; j < N; j++) {
                road[j] = map[j][i];
            }
            if (canInstallSlope(road)) count++;
        }

        System.out.println(count);
    }
}