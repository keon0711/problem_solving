import static java.lang.Integer.MAX_VALUE;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static final int END = 100_001;
    private static int count = 0;
    private static int time = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        bfs(N, M);

        System.out.println(time);
        System.out.println(count);
    }

    private static void bfs(int from, int to) {
        Queue<Integer> queue = new LinkedList<>();
        int[] cost = new int[END];
        Arrays.fill(cost, MAX_VALUE);
        queue.add(from);
        cost[from] = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int position = queue.poll();
                if (position == to) {
                    count++;
                }

                if (position + 1 < END && cost[position + 1] >= time + 1) {
                    cost[position + 1] = time + 1;
                    queue.add(position + 1);
                }
                if (position - 1 >= 0 && cost[position - 1] >= time + 1) {
                    cost[position - 1] = time + 1;
                    queue.add(position - 1);
                }
                if (position * 2 < END && cost[position * 2] >= time + 1) {
                    cost[position * 2] = time + 1;
                    queue.add(position * 2);
                }

            }

            if (count > 0) {
                return;
            }
            time++;
        }
    }
}