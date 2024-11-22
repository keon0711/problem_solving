import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 400001;
    
    static class State {
        int index, left, right, cost;
        
        State(int index, int left, int right, int cost) {
            this.index = index;
            this.left = left;
            this.right = right;
            this.cost = cost;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> moves = new ArrayList<>();
        
        while (true) {
            int move = Integer.parseInt(st.nextToken());
            if (move == 0) break;
            moves.add(move);
        }
        
        int n = moves.size();
        int[][][] visited = new int[n + 1][5][5];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(visited[i][j], INF);
            }
        }
        
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(0, 0, 0, 0));
        visited[0][0][0] = 0;
        
        while (!queue.isEmpty()) {
            State curr = queue.poll();
            
            if (curr.index == n) continue;
            if (curr.cost > visited[curr.index][curr.left][curr.right]) continue;
            
            int next = moves.get(curr.index);
            
            // 왼발 이동
            if (next != curr.right) {
                int newCost = curr.cost + getCost(curr.left, next);
                if (newCost < visited[curr.index + 1][next][curr.right]) {
                    visited[curr.index + 1][next][curr.right] = newCost;
                    queue.offer(new State(curr.index + 1, next, curr.right, newCost));
                }
            }
            
            // 오른발 이동
            if (next != curr.left) {
                int newCost = curr.cost + getCost(curr.right, next);
                if (newCost < visited[curr.index + 1][curr.left][next]) {
                    visited[curr.index + 1][curr.left][next] = newCost;
                    queue.offer(new State(curr.index + 1, curr.left, next, newCost));
                }
            }
        }
        
        int result = INF;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                result = Math.min(result, visited[n][i][j]);
            }
        }
        
        System.out.println(result);
    }
    
    static int getCost(int from, int to) {
        if (from == 0) return 2;
        if (from == to) return 1;
        if (Math.abs(from - to) == 2) return 4;
        return 3;
    }
}