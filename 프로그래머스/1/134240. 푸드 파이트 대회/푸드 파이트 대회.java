public class Solution {
    public String solution(int[] food) {
        StringBuilder leftSide = new StringBuilder();

        for (int i = 1; i < food.length; i++) {
            int count = food[i] / 2;
            for (int j = 0; j < count; j++) {
                leftSide.append(i);
            }
        }


        return leftSide.toString() + "0" + leftSide.reverse().toString();
    }
}