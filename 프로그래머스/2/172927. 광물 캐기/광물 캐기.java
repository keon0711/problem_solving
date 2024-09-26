class Solution {
    private static final int[][] FATIGUE = {{1,1,1}, {5,1,1}, {25,5,1}};
    private int minFatigue = Integer.MAX_VALUE;

    public int solution(int[] picks, String[] minerals) {
        dfs(picks, minerals, 0, 0);
        return minFatigue;
    }

    private void dfs(int[] picks, String[] minerals, int index, int fatigue) {
        if (index >= minerals.length || (picks[0] == 0 && picks[1] == 0 && picks[2] == 0)) {
            minFatigue = Math.min(minFatigue, fatigue);
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (picks[i] > 0) {
                picks[i]--;
                int newFatigue = fatigue + calculateFatigue(minerals, index, i);
                dfs(picks, minerals, index + 5, newFatigue);
                picks[i]++;
            }
        }
    }

    private int calculateFatigue(String[] minerals, int start, int pickType) {
        int fatigue = 0;
        for (int i = start; i < Math.min(start + 5, minerals.length); i++) {
            int mineralType = minerals[i].equals("diamond") ? 0 : minerals[i].equals("iron") ? 1 : 2;
            fatigue += FATIGUE[pickType][mineralType];
        }
        return fatigue;
    }
}