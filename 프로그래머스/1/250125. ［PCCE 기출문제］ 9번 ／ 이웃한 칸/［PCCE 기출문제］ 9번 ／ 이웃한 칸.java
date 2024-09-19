class Solution {
    public int solution(String[][] board, int h, int w) {

        int cnt = 0;
        if (h > 0 && board[h][w].equals(board[h - 1][w])) {
            cnt++;
        }
        if (h < board.length - 1 && board[h][w].equals(board[h + 1][w])) {
            cnt++;
        }
        if (w > 0 && board[h][w].equals(board[h][w - 1])) {
            cnt++;
        }
        if (w < board[0].length - 1 && board[h][w].equals(board[h][w + 1])) {
            cnt++;
        }

        return cnt;
    }
}