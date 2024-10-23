import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            simulation(from, to);
        }
    }

    private static void simulation(int from, int to) {
        Queue<Entry<Integer, String>> queue = new LinkedList<>();
        queue.offer(new SimpleEntry<>(from, ""));
        Set<Integer> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            Entry<Integer, String> poll = queue.poll();
            Integer key = poll.getKey();
            String value = poll.getValue();
            if (key.equals(to)) {
                System.out.println(value);
                return;
            }

            int[] nextStates = {D(key), S(key), L(key), R(key)};
            String[] operations = {"D", "S", "L", "R"};

            for (int i = 0; i < 4; i++) {
                int nextState = nextStates[i];
                if (!visited.contains(nextState)) {
                    visited.add(nextState);
                    queue.offer(new SimpleEntry<>(nextState, value + operations[i]));
                }
            }
        }
    }

    private static int D(int origin) {
        return (origin * 2) % 10000;
    }

    private static int S(int origin) {
        return origin - 1 == -1 ? 9999 : origin - 1;
    }

    private static int L(int origin) {
        return (origin % 1000) * 10 + (origin / 1000);
    }

    private static int R(int origin) {
        return (origin / 10) + (origin % 10) * 1000;
    }
}