import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[N + 1];
        combine(result, new ArrayList<>(), visited, N, M);

        for (List<Integer> integers : result) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    private static void combine(List<List<Integer>> result, ArrayList<Integer> tmp, boolean[] visited, int N, int M) {
        if (tmp.size() == M) {
            result.add(List.copyOf(tmp));
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                tmp.add(i);
                combine(result, tmp, visited, N, M);
                tmp.remove(tmp.size() - 1);
                visited[i] = false;
            }
        }
    }
}