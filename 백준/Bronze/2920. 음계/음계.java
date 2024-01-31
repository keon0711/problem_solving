import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(" ");
        boolean ascending = true;
        boolean descending = true;

        for (int i = 0; i < 8; i++) {
            int pitch = Integer.parseInt(split[i]);
            if (pitch != i + 1) {
                ascending = false;
            }
            if (pitch != 8 - i) {
                descending = false;
            }
        }
        if (ascending) {
            System.out.println("ascending");
        } else if (descending) {
            System.out.println("descending");
        } else {
            System.out.println("mixed");
        }
    }
}
