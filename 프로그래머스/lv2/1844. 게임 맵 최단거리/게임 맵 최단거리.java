import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int[] dx = new int[]{1, -1, 0, 0};
    int[] dy = new int[]{0, 0, 1, -1};

    public int solution(int[][] maps) {
        Queue<Position> que = new LinkedList<>();

        que.add(new Position(0, 0, 1));
        while (que.size() > 0) {
            Position pos = que.poll();
            if (pos.x == maps.length-1 && pos.y == maps[0].length - 1) {
                return pos.cnt;
            }
            for (int i = 0; i < 4; i++) {
                if (pos.x + dx[i] >= 0 && pos.x + dx[i] < maps.length
                        && pos.y + dy[i] >= 0 && pos.y + dy[i] < maps[0].length &&  maps[pos.x + dx[i]][pos.y + dy[i]] == 1 ) {
                    que.add(new Position(pos.x + dx[i], pos.y + dy[i], pos.cnt+1));
                    maps[pos.x + dx[i]][pos.y + dy[i]] = 0;
                }
            }
        }
        return -1;
    }

    public class Position {
        public int x;
        public int y;
        public int cnt;

        public Position(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}