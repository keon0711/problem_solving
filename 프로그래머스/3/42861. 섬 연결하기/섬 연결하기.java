import java.util.*;

class Solution {

    int[] parents;

    public int solution(int n, int[][] costs) {
        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        Arrays.sort(costs, Comparator.comparingInt(a -> a[2]));

        int edgeUsed = 0;
        int totalCost = 0;

        for (int[] cost : costs) {
            int start = cost[0];
            int end = cost[1];
            // 두 노드의 루트가 다를 때만 연결
            if (findParent(start) != findParent(end)) {
                unionParent(start, end);
                totalCost += cost[2];
                edgeUsed++;
            }
            // 모든 섬이 연결되면 종료
            if (edgeUsed == n - 1) {
                break;
            }
        }

        return totalCost;
    }

    private void unionParent(int start, int end) {
        int root1 = findParent(start);
        int root2 = findParent(end);

        if (root1 < root2) {
            parents[root2] = root1;
        } else {
            parents[root1] = root2;
        }
    }

    private int findParent(int node) {
        if (parents[node] != node) {
            parents[node] = findParent(parents[node]);
        }
        return parents[node];
    }
}