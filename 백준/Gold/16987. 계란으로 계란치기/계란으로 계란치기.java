import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] durability;
    static int[] weights;
    static int N;
    static int maxCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        durability = new int[N];
        weights = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            durability[i] = Integer.parseInt(st.nextToken());
            weights[i] = Integer.parseInt(st.nextToken());
        }
        if (N == 1) {
            System.out.println(0);
            return;
        }

        dfs(0, 0);
        System.out.println(maxCnt);
    }

    static void dfs(int index, int cnt) {
        if (index == N) {
            maxCnt = Math.max(cnt, maxCnt);
            return;
        }

        if (durability[index] <= 0) {
            dfs(index + 1, cnt);
            return;
        }

        int zeroCnt = 0;
        for (int i = 0; i < N; i++) {
            if (index == i) {
                continue;
            }
            if (durability[i] > 0) {
                durability[index] -= weights[i];
                durability[i] -= weights[index];

                int nextCnt = cnt;
                if (durability[index] <= 0)
                    nextCnt++;
                if (durability[i] <= 0)
                    nextCnt++;
                dfs(index + 1, nextCnt);

                durability[index] += weights[i];
                durability[i] += weights[index];
            } else {
                zeroCnt++;
            }
        }
        if (zeroCnt == N - 1)
            dfs(index + 1, cnt);
    }
}
