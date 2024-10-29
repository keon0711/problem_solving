import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static int N, M;
    private static int[] numbers;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        numbers = new int[N];
        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }
        Arrays.sort(numbers);
        permutation(new ArrayList<>());
    }

    private static void permutation(List<Integer> result) {
        if (result.size() == M) {
            System.out.println(result.stream().map(String::valueOf).collect(Collectors.joining(" ")));
            return;
        }

        for (int number : numbers) {
            if (result.contains(number)) {
                continue;
            }
            result.add(number);
            permutation(result);
            result.remove(result.size() - 1);
        }
    }


}

