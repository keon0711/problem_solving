import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> smallNumbers = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> bigNumbers = new PriorityQueue<>();

        int firstNumber = Integer.parseInt(br.readLine());
        smallNumbers.offer(firstNumber);
        System.out.println(firstNumber);

        for (int i = 0; i < N - 1; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num <= smallNumbers.peek()) {
                smallNumbers.add(num);
            } else {
                bigNumbers.add(num);
            }
            if (bigNumbers.size() > smallNumbers.size()) {
                smallNumbers.offer(bigNumbers.poll());
            } else if (smallNumbers.size() - bigNumbers.size() > 1) {
                bigNumbers.offer(smallNumbers.poll());
            }
            System.out.println(smallNumbers.peek());
        }
    }
}