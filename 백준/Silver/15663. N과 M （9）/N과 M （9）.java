import java.util.*;

public class Main {

    private static int N;
    private static int M;
    private static Set<List<Integer>> set = new HashSet<>();
    private static StringBuilder sb = new StringBuilder();
    private static int[] arr;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        permute(new ArrayList<>());


        System.out.println(sb.toString());
    }

    private static void permute(List<Integer> current) {
        if (current.size() == M) {
            if (set.contains(current)) {
                return;
            }
            set.add(new ArrayList<>(current));
            for (int i : current) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++ ) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            current.add(arr[i]);
            permute(current);
            current.remove(current.size() - 1);
            visited[i] = false;
        }

    }
}