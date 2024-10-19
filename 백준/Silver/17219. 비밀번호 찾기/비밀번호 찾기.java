import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            String[] split = s.split(" ");
            map.put(split[0], split[1]);
        }

        for (int i = 0; i < M; i++) {
            System.out.println(map.get(sc.nextLine()));
        }

    }
}