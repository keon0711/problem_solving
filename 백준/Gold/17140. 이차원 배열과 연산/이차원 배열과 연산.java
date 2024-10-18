import java.util.*;

public class Main {
    static int r, c, k;
    static int[][] A = new int[100][100];
    static int rowSize = 3, colSize = 3;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt() - 1; // 0-based index로 변환
        c = sc.nextInt() - 1;
        k = sc.nextInt();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        int result = simulate();
        System.out.println(result);
    }

    static int simulate() {
        for (int time = 0; time <= 100; time++) {
            if (r < rowSize && c < colSize && A[r][c] == k) {
                return time;
            }
            
            if (rowSize >= colSize) {
                operationR();
            } else {
                operationC();
            }
        }
        return -1;
    }

    static void operationR() {
        int maxCol = 0;
        for (int i = 0; i < rowSize; i++) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int j = 0; j < colSize; j++) {
                if (A[i][j] == 0) continue;
                countMap.merge(A[i][j], 1, Integer::sum);
            }
            
            List<int[]> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                list.add(new int[]{entry.getKey(), entry.getValue()});
            }
            list.sort((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
            
            int idx = 0;
            for (int[] pair : list) {
                if (idx >= 100) break;
                A[i][idx++] = pair[0];
                if (idx >= 100) break;
                A[i][idx++] = pair[1];
            }
            maxCol = Math.max(maxCol, idx);
            for (; idx < 100; idx++) {
                A[i][idx] = 0;
            }
        }
        colSize = Math.min(maxCol, 100);
    }

    static void operationC() {
        int maxRow = 0;
        for (int j = 0; j < colSize; j++) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int i = 0; i < rowSize; i++) {
                if (A[i][j] == 0) continue;
                countMap.merge(A[i][j], 1, Integer::sum);
            }
            
            List<int[]> list = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                list.add(new int[]{entry.getKey(), entry.getValue()});
            }
            list.sort((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
            
            int idx = 0;
            for (int[] pair : list) {
                if (idx >= 100) break;
                A[idx++][j] = pair[0];
                if (idx >= 100) break;
                A[idx++][j] = pair[1];
            }
            maxRow = Math.max(maxRow, idx);
            for (; idx < 100; idx++) {
                A[idx][j] = 0;
            }
        }
        rowSize = Math.min(maxRow, 100);
    }
}