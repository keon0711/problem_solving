import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] maxDp = new int[3];
        int[] minDp = new int[3];

        // 첫 줄 입력
        for(int j = 0; j < 3; j++) {
            int num = sc.nextInt();
            maxDp[j] = minDp[j] = num;
        }

        // 두 번째 줄부터 입력받으면서 처리
        for(int i = 1; i < N; i++) {
            int[] temp = maxDp.clone();
            int[] temp2 = minDp.clone();

            for(int j = 0; j < 3; j++) {
                int num = sc.nextInt();

                if(j == 0) {
                    maxDp[0] = num + Math.max(temp[0], temp[1]);
                    minDp[0] = num + Math.min(temp2[0], temp2[1]);
                }
                else if(j == 1) {
                    maxDp[1] = num + Math.max(Math.max(temp[0], temp[1]), temp[2]);
                    minDp[1] = num + Math.min(Math.min(temp2[0], temp2[1]), temp2[2]);
                }
                else {
                    maxDp[2] = num + Math.max(temp[1], temp[2]);
                    minDp[2] = num + Math.min(temp2[1], temp2[2]);
                }
            }
        }

        int max = Math.max(Math.max(maxDp[0], maxDp[1]), maxDp[2]);
        int min = Math.min(Math.min(minDp[0], minDp[1]), minDp[2]);

        System.out.println(max + " " + min);
        sc.close();
    }
}