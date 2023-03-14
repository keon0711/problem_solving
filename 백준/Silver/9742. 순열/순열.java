import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    void solution() throws IOException {
        int[] fact = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = br.readLine();
            if (str == null) {
                break;
            }
            StringTokenizer st = new StringTokenizer(str);
            String input = st.nextToken();
            List<Character> li = new LinkedList<>();
            for (Character character : input.toCharArray()) {
                li.add(character);
            }
            int index = Integer.parseInt(st.nextToken());

            System.out.printf("%s %d = ", input, index);
            if (fact[input.length()] < index) {
                System.out.println("No permutation");
            } else {
                StringBuilder sb = new StringBuilder();
                index -= 1;
                for (int i = input.length() - 1; i >= 0; i--) {
                    sb.append(li.get(index / fact[i]));
                    li.remove(index / fact[i]);
                    index %= fact[i];
                }
                System.out.println(sb);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}