import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;

public class Main {

    static Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
    private static String[] array;
    private static int L;
    private static int C;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        sc.nextLine();
        array = sc.nextLine().split(" ");
        Arrays.sort(array);

        combination(0, new StringBuilder());
        
    }

    private static void combination(int index, StringBuilder password) {
        if (password.length() == L) {
            if (isValid(password)) {
                System.out.println(password);
                return;
            }
        }

        for (int i = index; i < C; i++) {
            password.append(array[i]);
            combination(i + 1, password);
            password.deleteCharAt(password.length() - 1);
        }
    }

    private static boolean isValid(StringBuilder password) {
        int vowels = 0;
        for (int i = 0; i < password.length(); i++) {
            if (set.contains(password.charAt(i))) {
                vowels++;
            }
        }

        return vowels >= 1 && L - vowels >= 2;
    }
}