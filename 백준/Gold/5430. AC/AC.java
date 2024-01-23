import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            solve();
        }
    }

    private static void solve() throws IOException {
        String functions = br.readLine();
        int N = Integer.parseInt(br.readLine());
        String[] split = br.readLine().replaceAll("[\\[\\]]", "").split(",");
        LinkedList<Integer> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            q.add(Integer.valueOf(split[i]));
        }

        boolean reversed = false;
        for (char f : functions.toCharArray()) {
            if (f == 'R') {
                reversed = !reversed;
                continue;
            }
            if (q.isEmpty()) {
                System.out.println("error");
                return;
            }
            if (reversed) {
                q.pollLast();
            } else {
                q.pollFirst();
            }
        }
        if (reversed) {
            Collections.reverse(q);
        }
        System.out.println(q.toString().replaceAll(" ", ""));
    }
}