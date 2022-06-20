package boj20240;

import java.util.ArrayList;
import java.util.List;

class PointPicker {

    static class Point {
        int x, y, area;
        Point(int x, int y, int area) {
            this.x = x;
            this.y = y;
            this.area = area;
        }
        @Override
        public String toString() {
            return "(" + x + ", " + y + ") -> " + area;
        }
    }

    public static void main(String[] args) {

        List<Point> points = new ArrayList<>();
        int[] squares = new int[33];
        boolean[] visited = new boolean[10001];

        for (int i = 1; i < 33; i++) {
            int square = i * i;
            squares[i] = square;
            if (square < 1001 && !visited[square]) {
                points.add(new Point(i, 0, square));
                visited[square] = true;
            }
        }

        for (int i = 1; i < 33; i++) {
            for (int j = 1; j <= i; j++) {
                int sum = squares[i] + squares[j];
                if (sum < 1001 && !visited[sum]) {
                    points.add(new Point((int) Math.sqrt(squares[i]), (int) Math.sqrt(squares[j]), sum));
                    visited[sum] = true;
                }
            }
        }

        points.sort((a, b) -> {
            Point u = (Point) a;
            Point v = (Point) b;
            return u.area == v.area
                ? u.x == v.x
                    ? u.y - v.y
                    : u.x - v.x
                : u.area - v.area;
        });

        for (Point point : points) System.out.println(point);
        System.out.println("size: " + points.size());

    }

}
