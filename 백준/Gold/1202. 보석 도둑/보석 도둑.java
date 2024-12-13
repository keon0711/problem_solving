import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 보석의 개수
        int K = sc.nextInt(); // 가방의 개수

        Jewel[] jewels = new Jewel[N];
        for (int i = 0; i < N; i++) {
            int weight = sc.nextInt();
            int value = sc.nextInt();
            jewels[i] = new Jewel(weight, value);
        }

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = sc.nextInt();
        }

        // 보석과 가방 정렬
        Arrays.sort(jewels, Comparator.comparingInt(j -> j.weight));
        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long maxTotalValue = 0;
        int jewelIndex = 0;

        for (int bag : bags) {
            while (jewelIndex < N && jewels[jewelIndex].weight <= bag) {
                pq.offer(jewels[jewelIndex].value);
                jewelIndex++;
            }
            if (!pq.isEmpty()) {
                maxTotalValue += pq.poll();
            }
        }

        System.out.println(maxTotalValue);
    }

    static class Jewel {
        int weight, value;

        Jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}