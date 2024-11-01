import java.util.*;

public class Main {

    private static int[][] board;
    static List<int[]> emptyCells = new ArrayList<>();
    private static boolean solved;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        board = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int cell = sc.nextInt();
                if (cell == 0) {
                    emptyCells.add(new int[]{i, j});
                }
                board[i][j] = cell;
            }
        }

        dfs(0);
    }

    private static void printBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void dfs(int emptyCellIndex) {
        if (solved) {
            return;
        }

        if (emptyCellIndex == emptyCells.size()) {
            // 첫 번째 해답이므로, 결과 출력 후 종료
            printBoard();
            solved = true;
            return;
        }

        int r = emptyCells.get(emptyCellIndex)[0];
        int c = emptyCells.get(emptyCellIndex)[1];

        for (int num = 1; num <= 9; num++) {
            if (isValid(r, c, num)) {
                board[r][c] = num;
                dfs(emptyCellIndex + 1);
                board[r][c] = 0;
            }
        }
    }

    private static boolean isValid(int r, int c, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == num || board[i][c] == num) {
                return false;
            }
        }

        // 3x3 사각형 검사
        int squareRowStart = (r / 3) * 3;
        int squareColStart = (c / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[squareRowStart + i][squareColStart + j] == num) {
                    return false;
                }

            }
        }

        return true;
    }
}
