import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    static Scanner sc;
    static int N;
    static int M;
    static int[][] noteBook;
    static List<int[][]> stickers;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        noteBook = getNoteBook();
        stickers = getStickers();

        for (int[][] sticker : stickers) {
            for (int i = 0; i < 4; i++) {
                if (tryAttach(sticker)) {
                    break;
                }
                sticker = rotate(sticker);
            }
        }

        int count = Arrays.stream(noteBook)
            .flatMapToInt(Arrays::stream)
            .sum();
        System.out.println(count);

    }

    private static int[][] rotate(int[][] sticker) {
        int row = sticker.length;
        int col = sticker[0].length;

        int[][] rotatedSticker = new int[col][row];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                rotatedSticker[j][row - i - 1] = sticker[i][j];
            }
        }
        return rotatedSticker;
    }

    private static boolean canAttach(int row, int col, int[][] sticker) {
        for (int i = 0; i < sticker.length; i++) {
            for (int j = 0; j < sticker[i].length; j++) {
                if (row + i >= N || col + j >= M || (sticker[i][j] == 1 && noteBook[row + i][col + j] != 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean tryAttach(int[][] sticker) {

        for (int i = 0; i < noteBook.length; i++) {
            for (int j = 0; j < noteBook[i].length; j++) {
                if (canAttach(i, j, sticker)) {
                    attach(sticker, i, j);
                    return true;
                }
            }
        }
        return false;

    }

    private static void attach(int[][] sticker, int row, int col) {
        for (int i = 0; i < sticker.length; i++) {
            for (int j = 0; j < sticker[0].length; j++) {
                if (sticker[i][j] == 1) {
                    noteBook[row + i][col + j] = 1;
                }
            }
        }
    }

    private static int[][] getNoteBook() {
         N = sc.nextInt();
         M = sc.nextInt();
        return new int[N][M];
    }

    private static List<int[][]> getStickers() {
        List<int[][]> stickers = new ArrayList<>();
        int K = sc.nextInt();

        for (int i = 0; i < K; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int[][] sticker = new int[r][c];
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    sticker[j][k] = sc.nextInt();
                }
            }
            stickers.add(sticker);
        }
        return stickers;
    }
}