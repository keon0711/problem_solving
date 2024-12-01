import java.util.*;

public class Main {

    private static int N;
    private static int M;
    private static StringBuilder sb = new StringBuilder();
    private static List<Integer> numbers = new ArrayList<>();
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(sc.nextInt());
        }
        numbers = new ArrayList<>(set);
        numbers.sort(Integer::compareTo);
        N = numbers.size();
        visited = new boolean[N];

        permute(new ArrayList<>(), 0);

        System.out.println(sb.toString());
    }

    private static void permute(List<Integer> current, int start) {
        if (current.size() == M) {
            for (int i : current) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N; i++ ) {
            current.add(numbers.get(i));
            permute(current, i);
            current.remove(current.size() - 1);
        }

    }
}