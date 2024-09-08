import java.util.*;

class Solution {

    int[] dx = new int[]{-1, 0, 0, 1};
    int[] dy = new int[]{0, -1, 1, 0};
    int N;
    int M;

    public int solution(int[][] land) {

        N = land.length;
        M = land[0].length;

        int[] result = new int[M];
        boolean[] colFlag;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (land[i][j] == 0) {
                    continue;
                }
                colFlag = new boolean[M];
                int cnt = bfs(land, i, j, colFlag);

                for (int k = 0; k < M; k++) {
                    if (colFlag[k]) {
                        result[k] += cnt;
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < M; i++) {
            max = Math.max(max, result[i]);
        }
        return max;
    }

    public int bfs(int[][] land, int row, int col, boolean[] colFlag) {
        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{row, col});
        int sum = 0;

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int r = current[0], c = current[1];

            if (r < 0 || r >= N || c < 0 || c >= M || land[r][c] == 0) {
                continue;
            }

            land[r][c] = 0;
            colFlag[c] = true;
            sum++;

            for (int i = 0; i < 4; i++) {
                stack.push(new int[]{r + dx[i], c + dy[i]});
            }
        }

        return sum;
    }
}