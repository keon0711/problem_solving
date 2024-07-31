import java.util.Arrays;


class Solution {
    public int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];
        
        for (int i = 0; i < commands.length; i++) {
            // 1. 자르기
            int[] command = commands[i];
            int length = command[1] - command[0] + 1;
            int[] copy = new int[length];
            System.arraycopy(array, command[0] - 1, copy, 0, length);

            // 2. 정렬
            Arrays.sort(copy);

            // 3. n번째 숫자 찾기
            answer[i] = copy[command[2] - 1];
        }

        return answer;
    }
}