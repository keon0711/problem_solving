import java.util.ArrayList;
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
        List<Integer> b = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            b.add(scanner.nextInt());
        }

        List<Integer> answer = new ArrayList<>();

        // 최대값부터 탐색하여 공통 부분 수열을 찾음
        for (int i = 100; i >= 1; i--) {
            while (a.contains(i) && b.contains(i)) {
                answer.add(i);
                
                // 해당 요소 이후의 부분 수열로 업데이트
                a = a.subList(a.indexOf(i) + 1, a.size());
                b = b.subList(b.indexOf(i) + 1, b.size());
            }
        }

        // 결과 출력
        System.out.println(answer.size());
        for (int num : answer) {
            System.out.print(num + " ");
        }
    }
}