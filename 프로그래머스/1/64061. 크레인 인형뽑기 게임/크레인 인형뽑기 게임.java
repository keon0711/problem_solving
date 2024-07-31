import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int n = board.length;
        int[] tops = new int[n];
        Deque<Integer> basket = new ArrayDeque<>();
        int count = 0;

        // Initialize tops array
        for (int i = 0; i < n; i++) {
            tops[i] = getTopItem(board, i);
        }

        for (int move : moves) {
            int col = move - 1;
            if (tops[col] == n) continue; // Empty column

            int item = board[tops[col]++][col];
            
            if (!basket.isEmpty() && basket.peek() == item) {
                basket.pop();
                count += 2;
            } else {
                basket.push(item);
            }
        }

        return count;
    }

    private int getTopItem(int[][] board, int col) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] != 0) {
                return i;
            }
        }
        return board.length;
    }
}