import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();

        for (int s : score) {
            minHeap.offer(s);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
            result.add(minHeap.peek());
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}