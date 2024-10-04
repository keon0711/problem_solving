import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {

    private static final int SHEEP = 0;
    private static final int WOLF = 1;
    private int maxSheep = 0;

    private final Map<Integer, List<Integer>> tree = new HashMap<>();

    public int solution(int[] info, int[][] edges) {

        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            tree.computeIfAbsent(parent, k -> new ArrayList<>()).add(child);
        }

        List<Integer> nextNodes = new ArrayList<>();
        nextNodes.add(0);
        dfs(nextNodes, 0, 0, info);
        return maxSheep;
    }

    private void dfs(List<Integer> nodes, int sheep, int wolves, int[] info) {
        ArrayList<Integer> nextNodes = new ArrayList<>(nodes);

        for (Integer node : nodes) {
            int newSheep = sheep, newWolves = wolves;
            if (info[node] == SHEEP) {
                newSheep++;
            } else {
                newWolves++;
            }
            if (newSheep <= newWolves) {
                continue;
            }
            maxSheep = Math.max(maxSheep, newSheep);

            List<Integer> children = tree.getOrDefault(node, new ArrayList<>());

            nextNodes.addAll(children);
            nextNodes.remove(node);

            dfs(nextNodes, newSheep, newWolves, info);

            nextNodes.add(node);
            nextNodes.removeAll(children);
        }
    }

}