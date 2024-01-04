import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.add(s);
        }

        while (!pq.isEmpty() && pq.peek() < K) {
            Integer first = pq.poll();
            if (pq.isEmpty())
                return -1;
            Integer second = pq.poll();
            pq.offer(first + (second * 2));
            result++;
        }
        return result;
    }
}