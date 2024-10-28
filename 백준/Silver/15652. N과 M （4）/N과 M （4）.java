import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static int N;
    private static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        combination(1, new ArrayList<>());

    }

    private static void combination(int start, List<Integer> numbers) {
        if (numbers.size() == M) {
            System.out.println(numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
            return;
        }

        for (int i = start; i <= N; i++) {
            numbers.add(i);
            combination(i, numbers);
            numbers.remove(numbers.size() - 1);
        }
    }

}

