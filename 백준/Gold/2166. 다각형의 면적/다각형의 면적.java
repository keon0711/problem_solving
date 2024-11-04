import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        List<Point> points = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            points.add(new Point(sc.nextLong(), sc.nextLong()));
        }

        long area = 0;
        for (int i = 0; i < N; i++) {
            Point point1 = points.get(i);
            Point point2 = points.get((i + 1) % N);

            area += (point1.x * point2.y) - (point1.y * point2.x);
        }

        System.out.printf("%.1f", (double) Math.abs(area) / 2);


    }

    static class Point {
        long x, y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}
