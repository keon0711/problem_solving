class Solution {
    boolean[] visited;
    int maxCnt;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        maxCnt = 0;
        dfs(k, dungeons, 0);
        return maxCnt;
    }

    public void dfs(int k, int[][] dungeons, int cnt) {
        if (cnt > maxCnt)
            maxCnt = cnt;
        for (int i = 0; i < dungeons.length; i++) {
            int[] dungeon = dungeons[i];
            if (k < dungeon[0] || visited[i]) continue;
            visited[i] = true;
            dfs(k - dungeon[1], dungeons, cnt + 1);
            visited[i] = false;
        }
    }
}