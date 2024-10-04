import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (String op : operations) {
            if (op.equals("D 1")) {
                Integer poll = maxHeap.poll();
                if (poll != null) {
                    minHeap.remove(poll);
                }
            } else if (op.equals("D -1")) {
                Integer poll = minHeap.poll();
                if (poll != null) {
                    maxHeap.remove(poll);
                }
            } else {
                int num = Integer.parseInt(op.split(" ")[1]);
                maxHeap.add(num);
                minHeap.add(num);
            }
        }
        int min;
        if (minHeap.peek() != null) {
            min = minHeap.peek();
        } else {
            min = 0;
        } 
        int max;
        if (maxHeap.peek() != null) {
            max = maxHeap.peek();
        } else {
            max = 0;
        }
        return new int[]{max, min};
    }
}