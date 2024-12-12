import java.util.List;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (k != goal.length) {
            
            if (i < cards1.length && cards1[i].equals(goal[k])) {
                i++;
                k++;
                continue;
            }
            if (j < cards2.length && cards2[j].equals(goal[k])) {
                j++;
                k++;
                continue;
            }
            return "No";
        }
        return "Yes";
    }
}