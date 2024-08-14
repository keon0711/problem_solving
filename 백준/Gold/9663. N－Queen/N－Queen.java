import java.util.Scanner;

public class Main {

    static int N;
    static int[] row;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        row = new int[N];

        dfs(0);
        System.out.println(count);
    }

    private static void dfs(int curRow) {
        if (curRow == N) {
            count++;
            return;
        }
        for (int curCol = 0; curCol < N; curCol++) {
            if (isAvailable(curRow, curCol)) {
                row[curRow] = curCol;
                dfs(curRow + 1);
            }
        }
    }

    private static boolean isAvailable(int curRow, int curCol) {
        for (int r = 0; r < curRow; r++) {
            if (row[r] == curCol) {
                return false;
            }

            if (Math.abs(r - curRow) == Math.abs(row[r] - curCol)) {
                return false;
            }
        }
        return true;
    }
}