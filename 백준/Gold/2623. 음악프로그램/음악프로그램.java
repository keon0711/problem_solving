import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] indgree = new int[N + 1];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int numberOfSingers = sc.nextInt();

            int prev = sc.nextInt();
            for (int j = 1; j < numberOfSingers; j++) {
                int cur = sc.nextInt();
                indgree[cur]++;
                graph.get(prev).add(cur);
                prev = cur;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (indgree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int singer = queue.poll();
            result.add(singer);

            int len = graph.get(singer).size();
            for (int i = len - 1; i >= 0; i--) {
                int next = graph.get(singer).get(i);
                indgree[next]--;
                if (indgree[next] == 0) {
                    queue.add(next);
                    graph.get(singer).remove(i);
                }
            }
        }

        if (result.size() != N) {
            System.out.println(0);
            return;
        }

        for (Integer i : result) {
            System.out.println(i);
        }

    }
}