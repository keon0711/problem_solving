import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    private static List<int[]> emptyCells;
    private static int[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        board = new int[9][9];
        emptyCells = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < 9; j++) {
                 int num = line.charAt(j) - '0';
                if (num == 0) {
                    emptyCells.add(new int[]{i, j});
                }
                board[i][j] = num;
            }
        }

        dfs(0);
        String result = Arrays.stream(board)
            .map(row -> Arrays.stream(row)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("")))
            .collect(Collectors.joining("\n"));

        System.out.println(result);
    }

    private static boolean dfs(int index) {
        if (index == emptyCells.size()) {
            return true;
        }

        for (int i = 1; i <= 9; i++) {
            int[] point = emptyCells.get(index);
            if (isValid(point[0], point[1], i)) {
                board[point[0]][point[1]] = i;
                if (dfs(index + 1)) {
                    return true;
                }
                board[point[0]][point[1]] = 0;
            }
        }
        return false;
    }

    private static boolean isValid(int x, int y, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == num || board[i][y] == num) {
                return false;
            }
        }

        int startRow = (x / 3) * 3;
        int startCol = (y / 3) * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

}
