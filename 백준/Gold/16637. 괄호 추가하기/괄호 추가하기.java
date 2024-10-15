import java.util.Scanner;

public class Main {

    static int n;
    static String expression;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        expression = sc.next();

        dfs(0, expression.charAt(0) - '0');
        System.out.println(answer);
    }

    private static void dfs(int index, int currentResult) {
        if (index >= n - 1) {
            answer = Math.max(answer, currentResult);
            return;
        }


        char operator = expression.charAt(index + 1);
        int resultWithoutBracket = calculate(currentResult, operator, expression.charAt(index + 2) - '0');
        dfs(index + 2, resultWithoutBracket);

        if (index < n - 4) {
            int resultWithBracket = calculate(expression.charAt(index + 2) - '0', expression.charAt(index + 3), expression.charAt(index + 4) - '0');
            dfs(index + 4, calculate(currentResult, operator, resultWithBracket));
        }
    }

    private static int calculate(int op1, char operator, int op2) {
        switch (operator) {
            case '+':
                return op1 + op2;
            case '-':
                return op1 - op2;
            case '*':
                return op1 * op2;
            default:
                return 0;
        }
    }

}