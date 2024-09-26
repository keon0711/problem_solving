import java.util.*;

class Solution {
    private static final int INF = 1000000000;
    private static final int[][] FATIGUE = {
        {1, 1, 1},  // 다이아몬드 곡괭이
        {5, 1, 1},  // 철 곡괭이
        {25, 5, 1}  // 돌 곡괭이
    };

    public int solution(int[] picks, String[] minerals) {
        int totalPicks = picks[0] + picks[1] + picks[2];
        int[][][][] dp = new int[picks[0] + 1][picks[1] + 1][picks[2] + 1][Math.min(minerals.length, totalPicks * 5)];
        for (int[][][] a : dp) 
            for (int[][] b : a) 
                for (int[] c : b) 
                    Arrays.fill(c, -1);
        
        return minFatigue(picks[0], picks[1], picks[2], 0, minerals, dp);
    }

    private int minFatigue(int diamond, int iron, int stone, int idx, String[] minerals, int[][][][] dp) {
        if (idx >= minerals.length || idx >= dp[0][0][0].length) return 0;
        if (diamond + iron + stone == 0) return INF;

        if (dp[diamond][iron][stone][idx] != -1) return dp[diamond][iron][stone][idx];

        int result = INF;
        int[] currentGroup = getGroupMinerals(minerals, idx);

        if (diamond > 0) {
            int fatigue = calculateFatigue(currentGroup, 0);
            result = Math.min(result, fatigue + minFatigue(diamond - 1, iron, stone, idx + 5, minerals, dp));
        }
        if (iron > 0) {
            int fatigue = calculateFatigue(currentGroup, 1);
            result = Math.min(result, fatigue + minFatigue(diamond, iron - 1, stone, idx + 5, minerals, dp));
        }
        if (stone > 0) {
            int fatigue = calculateFatigue(currentGroup, 2);
            result = Math.min(result, fatigue + minFatigue(diamond, iron, stone - 1, idx + 5, minerals, dp));
        }

        return dp[diamond][iron][stone][idx] = result;
    }

    private int[] getGroupMinerals(String[] minerals, int startIdx) {
        int[] group = new int[3];  // [다이아몬드, 철, 돌]
        for (int i = 0; i < 5 && startIdx + i < minerals.length; i++) {
            switch (minerals[startIdx + i]) {
                case "diamond": group[0]++; break;
                case "iron": group[1]++; break;
                case "stone": group[2]++; break;
            }
        }
        return group;
    }

    private int calculateFatigue(int[] group, int pickType) {
        return group[0] * FATIGUE[pickType][0] + 
               group[1] * FATIGUE[pickType][1] + 
               group[2] * FATIGUE[pickType][2];
    }
}