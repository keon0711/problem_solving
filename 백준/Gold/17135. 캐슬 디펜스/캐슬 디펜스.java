import java.util.*;

class Main {
    static int N, M, D;
    static int[][] board;
    static int maxKill = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        D = sc.nextInt();
        
        board = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        
        // 궁수 배치의 모든 조합을 구하기
        List<int[]> combinations = new ArrayList<>();
        for (int i = 0; i < M - 2; i++) {
            for (int j = i + 1; j < M - 1; j++) {
                for (int k = j + 1; k < M; k++) {
                    combinations.add(new int[]{i, j, k});
                }
            }
        }
        
        for (int[] archers : combinations) {
            int killCount = simulate(archers);
            maxKill = Math.max(maxKill, killCount);
        }
        
        System.out.println(maxKill);
    }
    
    // 시뮬레이션 실행
    static int simulate(int[] archers) {
        int[][] tempBoard = new int[N][M];
        for (int i = 0; i < N; i++) {
            tempBoard[i] = board[i].clone();  // 보드 복사
        }
        
        int killCount = 0;
        for (int turn = 0; turn < N; turn++) {
            // 이번 턴에 궁수들이 공격할 적들을 찾는다.
            List<int[]> targets = new ArrayList<>();
            
            for (int archer : archers) {
                int[] target = findTarget(archer, tempBoard);
                if (target != null) {
                    targets.add(target);
                }
            }
            
            // 공격할 적들을 한 번에 제거
            for (int[] target : targets) {
                if (tempBoard[target[0]][target[1]] == 1) {
                    killCount++;
                    tempBoard[target[0]][target[1]] = 0; // 적 제거
                }
            }
            
            // 적 이동
            moveEnemies(tempBoard);
        }
        
        return killCount;
    }
    
    // 궁수가 공격할 적을 찾는 함수
    static int[] findTarget(int archerCol, int[][] tempBoard) {
        int minDist = D + 1;
        int[] target = null;
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (tempBoard[i][j] == 1) {  // 적이 있는 경우
                    int dist = Math.abs(N - i) + Math.abs(archerCol - j);
                    if (dist <= D) {
                        if (dist < minDist || (dist == minDist && j < target[1])) {
                            target = new int[]{i, j};
                            minDist = dist;
                        }
                    }
                }
            }
        }
        
        return target;
    }
    
    // 적을 한 칸 아래로 이동
    static void moveEnemies(int[][] tempBoard) {
        for (int i = N - 1; i > 0; i--) {
            for (int j = 0; j < M; j++) {
                tempBoard[i][j] = tempBoard[i - 1][j];
            }
        }
        // 첫 번째 행은 모두 빈 칸으로 설정
        for (int j = 0; j < M; j++) {
            tempBoard[0][j] = 0;
        }
    }
}