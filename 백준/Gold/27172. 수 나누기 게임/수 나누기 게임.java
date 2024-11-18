import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] cards = new int[n];
        int maxCard = 0;

        for (int i = 0; i < n; i++) {
            cards[i] = scanner.nextInt();
            if (cards[i] > maxCard) {
                maxCard = cards[i];
            }
        }

        int[] scores = new int[maxCard + 1];
        boolean[] hasCard = new boolean[maxCard + 1];

        for (int card : cards) {
            hasCard[card] = true;
        }

        for (int card : cards) {
            for (int multiple = card * 2; multiple <= maxCard; multiple += card) {
                if (hasCard[multiple]) {
                    scores[card]++;
                    scores[multiple]--;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int card : cards) {
            result.append(scores[card]).append(" ");
        }
        System.out.println(result.toString().trim());
    }
}