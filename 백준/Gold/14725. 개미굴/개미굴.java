import java.util.*;
import java.util.Map.Entry;

public class Main {

    private static final String FLOOR = "--";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        Node root = new Node();

        for (int i = 0; i < N; i++) {
            Node node = root;
            String[] split = sc.nextLine().split(" ");

            for (int j = 1; j < split.length; j++) {
                node.children.putIfAbsent(split[j], new Node(split[j]));
                node = node.children.get(split[j]);
            }
        }

        dfs(0, root);

    }

    private static void dfs(int depth, Node node) {
        for (Entry<String, Node> entries : node.children.entrySet()) {
            System.out.println(FLOOR.repeat(depth) + entries.getKey());
            dfs(depth + 1, entries.getValue());
        }


    }

    private static class Node {

        String value;
        Map<String, Node> children = new TreeMap<>();

        public Node(String value) {
            this.value = value;
        }

        public Node() {
        }
    }
}