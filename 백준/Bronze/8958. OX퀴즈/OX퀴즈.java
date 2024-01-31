import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            int score = 0;
            int consecutiveO = 0;
            for (char c :chars){
                if (c == 'O') {
                    score += ++consecutiveO;
                }
                if (c == 'X') {
                    consecutiveO = 0;
                }
            }
            System.out.println(score);
        }
    }
}
