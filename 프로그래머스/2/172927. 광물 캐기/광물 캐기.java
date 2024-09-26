class Solution {

    private static final int[][] FATIGUE = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
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

        for (int pickType = 0; pickType < 3; pickType++) {
            if (picks[pickType] > 0) {
                picks[pickType]--;
                int newFatigue = fatigue + calcGroupFatigue(pickType, minerals, index);
                dfs(picks, minerals, index + 5, newFatigue);
                picks[pickType]++;
            }
        }
    }

    private int calcGroupFatigue(int pick, String[] minerals, int index) {
        int fatigue = 0;
        for (int i = index; i < Math.min(index + 5, minerals.length); i++) {
            fatigue += calcFatigue(pick, minerals[i]);
        }
        return fatigue;
    }

    private int calcFatigue(int pick, String mineral) {
        int mineralType = mineral.equals("diamond") ? 0 : mineral.equals("iron") ? 1 : 2;
        return FATIGUE[pick][mineralType];
    }
}

