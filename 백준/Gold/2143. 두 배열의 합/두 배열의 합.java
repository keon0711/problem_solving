import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());

        // 배열 A의 부분합 계산
        int N = Integer.parseInt(br.readLine().trim());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Map<Integer, Integer> mapA = createCounter(A);

        // 배열 B의 부분합 계산
        int M = Integer.parseInt(br.readLine().trim());
        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        Map<Integer, Integer> mapB = createCounter(B);

        // 두 배열의 합 쌍 개수 계산
        long result = 0;
        for (int a : mapA.keySet()) {
            if (mapB.containsKey(T - a)) {
                result += (long) mapA.get(a) * mapB.get(T - a);
            }
        }

        System.out.println(result);
    }

    private static Map<Integer, Integer> createCounter(int[] array) {
        Map<Integer, Integer> counter = new HashMap<>();
        int n = array.length;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += array[j];
                counter.merge(sum, 1, Integer::sum);
            }
        }
        return counter;
    }
}