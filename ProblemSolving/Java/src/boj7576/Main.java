package boj7576;

import java.util.LinkedList;
import java.util.Queue;

class Main {

    static int N, M;

    public static void main(String[] args) throws Exception {

        M = read();
        N = read();

        boolean[][] tomatoBox = new boolean[N][M];
        Queue<Coord> queue = new LinkedList<>();

        int greenTomato = 0;
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                int tomato = System.in.read();

                if (tomato == 45) {
                    System.in.read();
                    tomatoBox[n][m] = true;
                } else if (tomato == 49) {
                    tomatoBox[n][m] = true;
                    queue.offer(new Coord(n, m));
                } else {
                    greenTomato++;
                }

                System.in.read();
            }
        }

        System.out.print(bfs(queue, tomatoBox, greenTomato));

    }

    static class Coord {
        int n;
        int m;
        Coord(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }

    static int bfs(Queue<Coord> queue, boolean[][] tomatoBox, int greenTomato) {

        int day = 0;

        final int[] dn = { -1, 1, 0, 0 };
        final int[] dm = { 0, 0, -1, 1 };

        while (!queue.isEmpty()) {

            if (greenTomato == 0) return day;

            int size = queue.size();

            while (size-- > 0) {

                int n = queue.peek().n;
                int m = queue.poll().m;

                for (int i = 0; i < 4; i++) {

                    int nn = n + dn[i];
                    int nm = m + dm[i];

                    if (nn < 0 || nm < 0 || nn == N || nm == M || tomatoBox[nn][nm]) continue;

                    greenTomato--;
                    tomatoBox[nn][nm] = true;
                    queue.offer(new Coord(nn, nm));

                }

            }

            day++;

        }

        return -1;

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
