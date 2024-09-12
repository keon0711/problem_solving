import java.util.*;

class Solution {

    public static final String EMPTY_SPACE = "-1";
    private static final int[] dr = new int[]{1, 0, 1};
    private static final int[] dc = new int[]{0, 1, 1};

    public int solution(int[] mats, String[][] park) {

        int maxSpace = 0;
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[0].length; j++) {
                if (park[i][j].equals(EMPTY_SPACE)) {
                    int size = getMaxSquareSize(park, i, j);
                    maxSpace = Math.max(maxSpace, size);
                }
            }
        }

        int answer = -1;
        for (int mat : mats) {
            if (maxSpace >= mat) {
                answer = Math.max(answer, mat);
            }
        }
        return answer;
    }

    private int getMaxSquareSize(String[][] park, int row, int col) {

        int size = 1;
        while (row + size < park.length && col + size < park[0].length) {

            for (int i = 0; i < size; i++) {
                if (!park[row + i][col + size].equals(EMPTY_SPACE) || !park[row + size][col + i].equals(EMPTY_SPACE)) {
                    return size;
                }
            }
            size++;
        }
        return size;
    }
}