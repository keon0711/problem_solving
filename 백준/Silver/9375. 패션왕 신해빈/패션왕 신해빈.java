import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine(); // 입력 버퍼 비우기

        while (T-- > 0) {
            int N = sc.nextInt();
            sc.nextLine(); // 입력 버퍼 비우기
            if (N == 0) {
                System.out.println(0);
                continue;
            }

            Map<String, Integer> counter = new HashMap<>();
            for (int i = 0; i < N; i++) {
                String[] input = sc.nextLine().split(" ");
                String type = input[1];
                counter.merge(type, 1, Integer::sum);
            }

            int result = 1;
            for (int count : counter.values()) {
                result *= (count + 1);
            }

            System.out.println(result - 1);
        }

        sc.close();
    }
}