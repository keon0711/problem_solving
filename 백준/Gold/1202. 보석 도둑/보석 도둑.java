import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 보석의 개수
        int K = sc.nextInt(); // 가방의 개수

        List<Jewel> jewels = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int weight = sc.nextInt();
            int value = sc.nextInt();
            jewels.add(new Jewel(weight, value));
        }

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = sc.nextInt();
        }

        // 보석과 가방 정렬
        jewels.sort(Comparator.comparingInt(j -> j.weight));
        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long maxTotalValue = 0;

        for (int bag : bags) {
            while (!jewels.isEmpty() && jewels.get(0).weight <= bag) {
                pq.offer(jewels.remove(0).value); // 첫 번째 보석을 꺼내 큐에 추가
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