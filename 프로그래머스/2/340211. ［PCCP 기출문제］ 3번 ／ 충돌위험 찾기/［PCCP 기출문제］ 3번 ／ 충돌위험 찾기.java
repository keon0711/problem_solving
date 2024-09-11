import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        Map<Integer, List<Point>> timePositionMap = new HashMap<>();

        // 각 로봇의 경로를 시간별로 맵에 저장
        for (int[] route : routes) {
            int time = 1;
            for (int i = 1; i < route.length; i++) {
                int[] start = points[route[i - 1] - 1];
                int[] end = points[route[i] - 1];
                int currentX = start[0], currentY = start[1];
                
                while (currentX != end[0] || currentY != end[1]) {
                    timePositionMap.computeIfAbsent(time, k -> new ArrayList<>())
                                   .add(new Point(currentX, currentY));
                    time++;

                    if (currentX != end[0]) {
                        currentX += Integer.compare(end[0], currentX);
                    } else if (currentY != end[1]) {
                        currentY += Integer.compare(end[1], currentY);
                    }
                }
                
                // 마지막 포인트 추가
                if (i == route.length - 1) {
                    timePositionMap.computeIfAbsent(time, k -> new ArrayList<>())
                                   .add(new Point(currentX, currentY));
                }
            }
        }

        // 각 시간대별로 충돌 위험 계산
        for (List<Point> positions : timePositionMap.values()) {
            Map<Point, Integer> positionCount = new HashMap<>();
            for (Point p : positions) {
                positionCount.merge(p, 1, Integer::sum);
            }
            answer += positionCount.values().stream().filter(count -> count > 1).count();
        }

        return answer;
    }

    static class Point {
        int x, y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}