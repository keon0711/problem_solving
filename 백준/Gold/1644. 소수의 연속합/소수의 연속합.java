import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // 소수 리스트 생성
        List<Integer> primes = generatePrimes(N);
        
        // 투 포인터로 연속된 소수의 합 찾기
        int count = 0;
        int start = 0;
        int end = 0;
        int sum = 0;
        
        while (start < primes.size()) {
            // 현재 합이 N보다 작고 end가 범위 안에 있으면 end를 증가
            while (end < primes.size() && sum < N) {
                sum += primes.get(end);
                end++;
            }
            
            // 합이 N과 같으면 경우의 수 증가
            if (sum == N) {
                count++;
            }
            
            // start 포인터를 이동하면서 합에서 제외
            sum -= primes.get(start);
            start++;
        }
        
        System.out.println(count);
    }
    
    // N 이하의 소수들을 생성하는 메소드
    private static List<Integer> generatePrimes(int N) {
        boolean[] isComposite = new boolean[N + 1];
        List<Integer> primes = new ArrayList<>();
        
        // 에라토스테네스의 체
        for (int i = 2; i * i <= N; i++) {
            if (!isComposite[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isComposite[j] = true;
                }
            }
        }
        
        // 소수 리스트 생성
        for (int i = 2; i <= N; i++) {
            if (!isComposite[i]) {
                primes.add(i);
            }
        }
        
        return primes;
    }
}