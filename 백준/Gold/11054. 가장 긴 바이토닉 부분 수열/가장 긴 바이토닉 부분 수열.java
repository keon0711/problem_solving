import java.util.*;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int[] increase = new int[N];
        int[] decrease = new int[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    increase[i] = Math.max(increase[j] + 1, increase[i]);
                }
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j > i; j--) {
                if (arr[i] > arr[j]) {
                    decrease[i] = Math.max(decrease[j] + 1, decrease[i]);
                }
            }
        }

        int max = IntStream.range(0, N).map(i -> increase[i] + decrease[i]).max().getAsInt();
        System.out.println(max + 1);

    }
}