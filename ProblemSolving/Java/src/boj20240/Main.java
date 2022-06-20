package boj20240;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Main {

    static class Point {
        int x, y, area;
        Point(int x, int y, int area) {
            this.x = x;
            this.y = y;
            this.area = area;
        }
    }

    public static void main(String[] args) throws Exception {

        int s = read();

        List<Point> points = new ArrayList<>();
        int[] squares = new int[s + 1];

        for (int i = 1; i <= s; i++) {
            int square = i * i;
            squares[i] = square;
            if (square > s) break;
            points.add(new Point(i, 0, square));
        }

        for (int i = 1; i <= s; i++) {
            for (int j = 1; j <= i; j++) {
                int sum = squares[i] + squares[j];
                if (sum > s) break;
                points.add(new Point((int) Math.sqrt(squares[i]), (int) Math.sqrt(squares[j]), sum));
            }
        }

        Optional<Point> point = points.stream().filter(p -> p.area == s).findAny();

        if (point.isPresent()) {
            printPoints(point.get());
        } else {
            System.out.print("Impossible");
        }

    }

    static void printPoints(Point point) {
        int[] dx = {1, -1, -1};
        int[] dy = {1, 1, -1};

        int[] pos = {point.x, point.y};
        int[] prev = {0, 0};

        StringBuilder sb = new StringBuilder();
        sb.append(prev[0]).append(' ').append(prev[1]).append('\n');

        for (int i = 0; i < 3; i++) {
            prev[0] += pos[0] * dx[i];
            prev[1] += pos[1] * dy[i];
            int t = pos[0];
            pos[0] = pos[1];
            pos[1] = t;
            sb.append(prev[0]).append(' ').append(prev[1]).append('\n');
        }

        System.out.print(sb);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
