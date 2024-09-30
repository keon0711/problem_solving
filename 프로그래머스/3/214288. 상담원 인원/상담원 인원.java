import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Solution {

    public int solution(int k, int n, int[][] reqs) {
        List<int[]> combs = new ArrayList<>();
        int[] comb = new int[k + 1];
        Arrays.fill(comb, 1);
        generateCombinationsRecursive(comb, k, n - k, 1, combs);

        for (int[] c : combs) {
            System.out.println(Arrays.toString(c));
        }

        int min = Integer.MAX_VALUE;
        for (int[] c : combs) {
            int waitingTime = simulation(c, reqs);
            min = Math.min(min, waitingTime);
        }

        return min;
    }

    private int simulation(int[] comb, int[][] reqs) {
        PriorityQueue<Integer>[] pqs = new PriorityQueue[comb.length];
        int waitingTime = 0;

        // 상담 타입 별 우선순위 큐 생성 (멘토 수만큼 0을 추가)
        for (int i = 1; i < comb.length; i++) {
            pqs[i] = new PriorityQueue<>();
            for (int j = 0; j < comb[i]; j++) {
                pqs[i].add(0);
            }
        }

        for (int[] req : reqs) {
            int startTime = req[0];
            int spentTime = req[1];
            int type = req[2];

            PriorityQueue<Integer> mentor = pqs[type];
            Integer availableTime = mentor.poll();

            if (availableTime > startTime) {
                waitingTime += (availableTime - startTime);
                mentor.offer(availableTime + spentTime);
            } else {
                mentor.offer(startTime + spentTime);
            }

        }

        return waitingTime;
    }

    private void generateCombinationsRecursive(int[] combination, int k, int r, int index,
        List<int[]> result) {
        if (r == 0) {
            result.add(Arrays.copyOf(combination, combination.length));
            return;
        }

        for (int i = index; i <= k; i++) {
            combination[i] += 1;
            generateCombinationsRecursive(combination, k, r - 1, i, result);
            combination[i] -= 1;
        }
    }

}