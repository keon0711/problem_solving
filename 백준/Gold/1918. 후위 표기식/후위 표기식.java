import java.util.Scanner;
import java.util.Stack;

public class Main {

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    private static int getPrecedence(char operator) {
        return switch (operator) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            default -> -1;
        };
    }

    public static String convertToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {
            char currentChar = infix.charAt(i);

            if (Character.isAlphabetic(currentChar)) {
                postfix.append(currentChar);
            }
            else if (currentChar == '(') {
                stack.push(currentChar);
            }
            else if (currentChar == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();
            }
            else if (isOperator(currentChar)) {
                while (!stack.isEmpty() && getPrecedence(stack.peek()) >= getPrecedence(currentChar)) {
                    postfix.append(stack.pop());
                }
                stack.push(currentChar);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String postfixExpression = convertToPostfix(sc.nextLine());
        System.out.println(postfixExpression);
    }
}
