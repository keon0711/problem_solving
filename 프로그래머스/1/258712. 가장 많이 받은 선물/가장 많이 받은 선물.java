import java.util.*;

class Solution {
    
    public int solution(String[] friends, String[] gifts) {
        int[][] history = new int[friends.length][friends.length];
        int[] giftPoint = new int[friends.length];
        int[] giftCounter = new int[friends.length];
        
        Map<String, Integer> friendsIndex = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            friendsIndex.put(friends[i], i);
        }
        
        for (String gift: gifts) {
            String[] split = gift.split(" ");
            int f1 = friendsIndex.get(split[0]);
            int f2 = friendsIndex.get(split[1]);
            
            history[f1][f2]++;
            history[f2][f1]--;
            
            giftPoint[f1]++;
            giftPoint[f2]--;
        }
        
        for(int i = 0; i < friends.length; i++) {
            for (int j = i + 1; j < friends.length; j ++) {
                Integer i1 = history[i][j];
                Integer i2 = history[j][i];
                
                
                if (i1 > i2) {
                    giftCounter[i]++;
                } else if (i1 < i2) {
                    giftCounter[j]++;
                } else {
                    if (giftPoint[i] > giftPoint[j])
                        giftCounter[i]++;
                    else if (giftPoint[i] < giftPoint[j]) {
                        giftCounter[j]++;
                    }
                }
            }
        }
        
        return Arrays.stream(giftCounter).max().getAsInt();
        
    }
}