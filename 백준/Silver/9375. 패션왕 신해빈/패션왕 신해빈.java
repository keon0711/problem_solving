import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            simulate();
        }

        sc.close();
    }

    private static void simulate() {
        int N = sc.nextInt();
        if (N == 0) {
            System.out.println(0);
            return;
        }

        Map<String, Integer> counter = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String clothes = sc.next(); // 의상의 이름 (사용하지 않음)
            String type = sc.next();    // 의상의 종류
            counter.merge(type, 1, Integer::sum);
        }

        int result = 1;
        for (int count : counter.values()) {
            result *= (count + 1);
        }

        System.out.println(result - 1);
    }
}