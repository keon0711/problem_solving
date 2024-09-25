import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int totalPicks = Arrays.stream(picks).sum();
        int groupCount = Math.min((minerals.length + 4) / 5, totalPicks);
        
        List<int[]> mineralGroups = new ArrayList<>();
        
        for (int i = 0; i < groupCount; i++) {
            int[] group = new int[3]; // diamond, iron, stone
            for (int j = i * 5; j < Math.min((i + 1) * 5, minerals.length); j++) {
                if (minerals[j].equals("diamond")) group[0]++;
                else if (minerals[j].equals("iron")) group[1]++;
                else group[2]++;
            }
            mineralGroups.add(group);
        }
        
        mineralGroups.sort((a, b) -> (b[0] * 25 + b[1] * 5 + b[2]) - (a[0] * 25 + a[1] * 5 + a[2]));
        
        int fatigue = 0;
        int pickIndex = 0;
        
        for (int[] group : mineralGroups) {
            while (pickIndex < 3 && picks[pickIndex] == 0) pickIndex++;
            if (pickIndex == 3) break;
            
            picks[pickIndex]--;
            
            if (pickIndex == 0) { // diamond pick
                fatigue += group[0] + group[1] + group[2];
            } else if (pickIndex == 1) { // iron pick
                fatigue += group[0] * 5 + group[1] + group[2];
            } else { // stone pick
                fatigue += group[0] * 25 + group[1] * 5 + group[2];
            }
        }
        
        return fatigue;
    }
}