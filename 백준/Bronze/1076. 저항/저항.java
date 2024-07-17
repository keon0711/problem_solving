import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<String> colors = List.of("black", "brown", "red", "orange", "yellow", "green", "blue",
            "violet", "grey", "white");

        Scanner sc = new Scanner(System.in);
        int first = colors.indexOf(sc.nextLine());
        int second = colors.indexOf(sc.nextLine());
        int third = colors.indexOf(sc.nextLine());

        long result = 0;
        if (first != 0) {
            result = first * 10;
        }
        result += second;
        result *= (int) Math.pow(10, third);
        System.out.println(result);
        
    }

}
