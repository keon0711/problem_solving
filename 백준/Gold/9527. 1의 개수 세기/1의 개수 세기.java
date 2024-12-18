import java.util.Scanner;  
  
public class Main {  

    private static long countOnes(long x) {  
        long count = 0;  
        long powerOfTwo = 1;  
  
        while (powerOfTwo <= x) {  
            // 그룹이 몇번 반복되는 지
            long completeBlocks = x / (powerOfTwo * 2);  
            // 그룹 반복 횟수 X 1의 등장 횟수
            count += completeBlocks * powerOfTwo;  

			// 남은 숫자에서 1 계산
            long remainder = x % (powerOfTwo * 2);  
            count += Math.max(0, remainder - powerOfTwo + 1);  
  
            powerOfTwo *= 2;  
        }  
  
        return count;  
    }  
  
    public static void main(String[] args) {  
        Scanner sc = new Scanner(System.in);  
        long A = sc.nextLong();  
        long B = sc.nextLong();  
  
        long result = countOnes(B) - countOnes(A - 1);  
        System.out.println(result);  
    }  
}