import java.util.Scanner;

public class Main {
    public static long modExp(long base, long exp, long mod) {
        long result = 1;
        base = base % mod; // 초기 base를 mod로 나눠 크기 줄이기

        while (exp > 0) {
            // 지수가 홀수인 경우 현재 base를 결과에 곱함
            if (exp % 2 == 1) {
                result = (result * base) % mod;
            }
            // 지수를 반으로 줄이고 base를 제곱하여 업데이트
            exp = exp / 2;
            base = (base * base) % mod;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        long C = sc.nextLong();
        System.out.println(modExp(A, B, C));
        sc.close();
    }
}