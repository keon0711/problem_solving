import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {

        Map<Integer, List<Point>> timePositionMap = new HashMap<>();
        for (int[] route : routes) {
            int time = 0;
            for (int i = 0; i < route.length - 1; i++) {
                int[] startPoint = points[route[i] - 1];
                int[] endPoint = points[route[i + 1] - 1];
                int curX = startPoint[0];
                int curY = startPoint[1];

                while (curX != endPoint[0] || curY != endPoint[1]) {
                    timePositionMap.computeIfAbsent(time++, k -> new ArrayList<>())
                        .add(new Point(curX, curY));

                    if (curX != endPoint[0]) {
                        curX += Integer.compare(endPoint[0], curX);
                    } else if (curY != endPoint[1]) {
                        curY += Integer.compare(endPoint[1], curY);
                    }
                }

                if (i == route.length - 2) {
                    timePositionMap.computeIfAbsent(time, k -> new ArrayList<>())
                        .add(new Point(curX, curY));
                }
            }

        }

        int count = 0;
        for (List<Point> pointList : timePositionMap.values()) {
            Map<Point, Integer> collisionCounter = new HashMap<>();
            for (Point point : pointList) {
                collisionCounter.merge(point, 1, Integer::sum);
            }
            count += collisionCounter.values().stream().filter(v -> v > 1).count();
        }

        return count;
    }


    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}