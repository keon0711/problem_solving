import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private int[] dy = new int[]{-1, 0, 0, 1};
    private int[] dx = new int[]{0, -1, 1, 0};
    private int step = 0;

    public int solution(String[] maps) {
        char[][] map = new char[maps.length][];

        int startX = 0, startY = 0;

        for (int i = 0; i < maps.length; i++) {
            int index = maps[i].indexOf('S');
            if (index != -1) {
                startY = i;
                startX = index;
            }
            map[i] = maps[i].toCharArray();
        }

        int[] leverPos = bfs(maps, startY, startX, map, 'L');
        if (leverPos.length == 0) {
            return -1;
        }
        int[] exitPos = bfs(maps, leverPos[0], leverPos[1], map, 'E');
        if (exitPos.length == 0) {
            return -1;
        }
        return step;
    }

    private int[] bfs(String[] maps, int startY, int startX, char[][] map, char target) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{startY, startX, 0});
        boolean[][] visited = new boolean[maps.length][maps[0].length()];

        while (!que.isEmpty()) {
            int[] poll = que.poll();
            int y = poll[0], x = poll[1], step = poll[2];
            System.out.println(y + " " + x + " " + step);
            if (map[y][x] == target) {
                System.out.println(step);
                this.step += step;
                return new int[]{y, x};
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (ny >= 0 && ny < map.length && nx >= 0 && nx < map[0].length
                    && !visited[ny][nx] && map[ny][nx] != 'X') {
                    visited[ny][nx] = true;
                    que.add(new int[]{ny, nx, step + 1});
                }
            }
        }
        return new int[]{};
    }
}