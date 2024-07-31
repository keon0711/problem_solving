import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public int solution(int[][] board, int[] moves) {
        List<List<Integer>> newBoard = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < board.length; i++) {
            newBoard.add(new ArrayList<>());
        }

        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 0) {
                    continue;
                }
                newBoard.get(j).add(board[i][j]);
            }
        }

        int count = 0;
        for (int move : moves) {
            List<Integer> line = newBoard.get(move - 1);
            if (line.isEmpty()) {
                continue;
            }
            
            Integer item = line.remove(line.size() - 1);
            if (item.equals(stack.peek())) {
                stack.pop();
                count += 2;
            } else {
                stack.push(item);
            }
        }
        return count;
    }
}