import java.util.*;

public class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            String binary = Long.toBinaryString(numbers[i]);

            int treeHeight = 1;
            while ((1 << treeHeight) - 1 < binary.length()) {
                treeHeight++;
            }
            int fullLength = (1 << treeHeight) - 1;
            binary = String.format("%" + fullLength + "s", binary).replace(' ', '0');

            answer[i] = isValidTree(binary, 0, binary.length() - 1, true) ? 1 : 0;
        }

        return answer;
    }

    private boolean isValidTree(String binary, int start, int end, boolean parentIsOne) {
        if (start > end) return true;

        int mid = (start + end) / 2;
        boolean currentIsOne = binary.charAt(mid) == '1';

        // 부모가 0인데 현재 노드가 1인 경우 트리 규칙을 어긋남
        if (!parentIsOne && currentIsOne) return false;

        // 좌우 자식 트리를 재귀적으로 탐색
        return isValidTree(binary, start, mid - 1, currentIsOne) &&
            isValidTree(binary, mid + 1, end, currentIsOne);
    }
}