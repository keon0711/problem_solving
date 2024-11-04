import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        int left = 0;
        int right = N - 1;

        int[] closestPair = new int[]{numbers[0], numbers[N - 1]};
        while (left < right) {
            if (Math.abs(numbers[left] + numbers[right]) < Math.abs(closestPair[0] + closestPair[1])) {
                closestPair[0] = numbers[left];
                closestPair[1] = numbers[right];
            }

            if (numbers[left] + numbers[right] == 0) {
                break;
            } else if (numbers[left] + numbers[right] < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(closestPair[0] + " " + closestPair[1]);
    }
}
