import java.io.*;
import java.util.*;

public class Main {

    static int[][][] dp;
    static ArrayList<Integer> moves;
    static final int INF = 400001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        moves = new ArrayList<>();

        while (true) {
            int move = Integer.parseInt(st.nextToken());
            if (move == 0) {
                break;
            }
            moves.add(move);
        }

        dp = new int[moves.size() + 1][5][5];
        for (int i = 0; i < moves.size() + 1; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        System.out.println(solve(0, 0, 0));
    }

    static int getCost(int from, int to) {
        if (from == 0) {
            return 2;
        }
        if (from == to) {
            return 1;
        }
        if (Math.abs(from - to) == 2) {
            return 4;
        }
        return 3;
    }

    static int solve(int index, int left, int right) {
        if (index == moves.size()) {
            return 0;
        }

        if (dp[index][left][right] != -1) {
            return dp[index][left][right];
        }

        int nextPos = moves.get(index);
        int result = INF;

        if (nextPos != right) {
            result = Math.min(result, solve(index + 1, nextPos, right) + getCost(left, nextPos));
        }

        if (nextPos != left) {
            result = Math.min(result, solve(index + 1, left, nextPos) + getCost(right, nextPos));
        }

        dp[index][left][right] = result;
        return result;
    }
}