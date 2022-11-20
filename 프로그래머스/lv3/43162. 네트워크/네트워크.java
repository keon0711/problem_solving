class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                cnt++;
                dfs(computers, visited, i);
            }
        }
        return cnt;
    }

    public void dfs(int[][] computers, boolean[] visited, int computer) {
        for (int i = 0; i < computers.length; i++) {
            if (computers[computer][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(computers, visited, i);
            }
        }
    }
}