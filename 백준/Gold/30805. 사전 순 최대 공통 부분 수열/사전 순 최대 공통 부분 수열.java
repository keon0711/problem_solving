import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 첫 번째 수열 입력
        int n = scanner.nextInt();
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(scanner.nextInt());
        }

        // 두 번째 수열 입력
        int m = scanner.nextInt();
        HashSet<Integer> setB = new HashSet<>();
        List<Integer> b = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int num = scanner.nextInt();
            b.add(num);
            setB.add(num); // 두 번째 수열의 요소를 Set에 저장
        }

        List<Integer> answer = new ArrayList<>();

        // 큰 값부터 탐색하면서 공통 부분 수열 찾기
        for (int i = 100; i >= 1; i--) {
            while (a.contains(i) && setB.contains(i)) {
                answer.add(i);
                a = a.subList(a.indexOf(i) + 1, a.size());
                int idx = b.indexOf(i);
                b = b.subList(idx + 1, b.size());
                setB = new HashSet<>(b); // b의 남은 부분으로 Set 재구성
            }
        }

        // 결과 출력
        System.out.println(answer.size());
        for (int num : answer) {
            System.out.print(num + " ");
        }
    }
}