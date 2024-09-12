import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int lastTime = attacks[attacks.length - 1][0];
        Map<Integer, Integer> attackTimes = new HashMap<>();

        for (int[] attack : attacks) {
            attackTimes.put(attack[0], attack[1]);
        }

        int bandageTime = 0;
        int currentHealth = health;
        for (int time = 0; time <= lastTime; time++) {
            if (attackTimes.containsKey(time)) {
                currentHealth -= attackTimes.get(time);
                bandageTime = 0;
                if (currentHealth <= 0) {
                    return -1;
                }
            } else {
                currentHealth += bandage[1];
                bandageTime++;
                if (bandageTime == bandage[0]) {
                    currentHealth += bandage[2];
                    bandageTime = 0;
                }
                currentHealth = Math.min(currentHealth, health);
            }
        }
        return currentHealth;
    }
}