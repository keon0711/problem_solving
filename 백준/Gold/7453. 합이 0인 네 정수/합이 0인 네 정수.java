import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        // 1. AB와 CD의 모든 조합 합을 저장
        int[] AB = new int[n * n];
        int[] CD = new int[n * n];
        int index = 0;

        for (int a : A) {
            for (int b : B) {
                AB[index++] = a + b;
            }
        }

        index = 0;
        for (int c : C) {
            for (int d : D) {
                CD[index++] = c + d;
            }
        }

        // 2. AB는 오름차순, CD는 내림차순으로 정렬
        Arrays.sort(AB);
        Arrays.sort(CD);

        int left = 0;
        int right = CD.length - 1;
        long count = 0;

        // 3. 두 포인터를 사용해 AB와 -CD의 합을 탐색
        while (left < AB.length && right >= 0) {
            int sum = AB[left] + CD[right];

            if (sum == 0) {
                // AB[left]와 CD[right]의 동일한 값 개수 누적
                long abCount = 1;
                long cdCount = 1;

                while (left + 1 < AB.length && AB[left] == AB[left + 1]) {
                    left++;
                    abCount++;
                }

                while (right - 1 >= 0 && CD[right] == CD[right - 1]) {
                    right--;
                    cdCount++;
                }

                // 쌍의 개수 추가
                count += abCount * cdCount;
                left++;
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(count);
    }
}