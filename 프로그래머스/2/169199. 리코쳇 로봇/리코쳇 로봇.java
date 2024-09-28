import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {

    private final int[] dx = new int[]{1, -1, 0, 0};
    private final int[] dy = new int[]{0, 0, 1, -1};

    public int solution(String[] board) {
        char[][] map = Arrays.stream(board)
            .map(String::toCharArray)
            .toArray(char[][]::new);

        Queue<int[]> pq = new LinkedList<>();

        for (int row = 0; row < board.length; row++) {
            int col = board[row].indexOf("R");
            if (col != -1) {
                pq.add(new int[]{row, col, 0});
                map[row][col] = 'x';
                break;
            }
        }

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int row = cur[0];
            int col = cur[1];
            int moveCount = cur[2];

            for (int i = 0; i < 4; i++) {
                int nextRow = row;
                int nextCol = col;
                while (isMovable(nextRow, nextCol, i, map)) {
                    nextRow += dx[i];
                    nextCol += dy[i];
                }

                if (map[nextRow][nextCol] == 'G') {
                    return moveCount + 1;
                }

                if (map[nextRow][nextCol] != 'x') {
                    pq.add(new int[]{nextRow, nextCol, moveCount + 1});
                    map[nextRow][nextCol] = 'x';
                }
            }
        }

        return -1;

    }

    private boolean isMovable(int row, int col, int i, char[][] map) {
        int nextRow = row + dx[i];
        int nextCol = col + dy[i];
        return nextRow >= 0 && nextRow < map.length && nextCol >= 0
            && col + dy[i] < map[0].length && map[nextRow][nextCol] != 'D';
    }
}