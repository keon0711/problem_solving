import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        int[] numbers = new int[N];
        int maxNum = 0;
        int[] index = new int[1000001];  // 각 숫자의 인덱스를 저장
        
        for(int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
            maxNum = Math.max(maxNum, numbers[i]);
            index[numbers[i]] = i + 1;    // 1-based index 저장
        }
        
        int[] score = new int[N];
        
        for(int i = 0; i < N; i++) {
            int current = numbers[i];
            // current의 배수들을 확인
            for(int j = current * 2; j <= maxNum; j += current) {
                if(index[j] > 0) {        // 해당 숫자가 존재하면
                    score[i]++;           // current는 점수 획득
                    score[index[j]-1]--;  // j는 점수 감소
                }
            }
        }
        
        for(int i = 0; i < N; i++) {
            System.out.print(score[i] + " ");
        }
    }
}