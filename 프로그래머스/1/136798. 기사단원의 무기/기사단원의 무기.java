class Solution {
    public int solution(int number, int limit, int power) {
        int[] divisorCount = new int[number + 1];

        for (int i = 1; i <= number; i++) {
            for (int j = i; j <= number; j += i) {
                divisorCount[j]++;
            }
        }

        int totalCost = 0;
        for (int i = 1; i <= number; i++) {
            if (divisorCount[i] > limit) {
                totalCost += power;
            } else {
                totalCost += divisorCount[i];
            }
        }

        return totalCost;
    }
}