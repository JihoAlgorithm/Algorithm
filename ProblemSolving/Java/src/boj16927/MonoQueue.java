package boj16927;

import java.util.*;

class MonoQueue {

    static int N, M, R, layers;
    static int[][] array;
    static final int[] dr = {0, 1, 0, -1};
    static final int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {

        N = read();
        M = read();
        R = read();

        layers = (N < M ? N : M) >> 1;
        Queue<Integer> queue = new LinkedList<>();
        array = new int[N][M];

        for (int n = 0; n < N; n++) for (int m = 0; m < M; m++) array[n][m] = read();

        for (int layer = 0; layer < layers; layer++) {
            int r, c;

            r = c = layer;
            queue.offer(array[r][c]);
            for (int d = 0; d < 4; d++) {
                while (true) {
                    r += dr[d];
                    c += dc[d];
                    if (isOut(r, c, layer)) {
                        r -= dr[d];
                        c -= dc[d];
                        break;
                    }
                    queue.offer(array[r][c]);
                }
            }

            int round = R % ((N + M - 2 - (layer << 2)) << 1);
            while (round-- > 0) queue.offer(queue.poll());

            r = c = layer;
            array[r][c] = queue.poll();

            for (int d = 0; d < 4; d++) {
                while (true) {
                    r += dr[d];
                    c += dc[d];
                    if (isOut(r, c, layer)) {
                        r -= dr[d];
                        c -= dc[d];
                        break;
                    }
                    array[r][c] = queue.poll();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++)
                sb.append(array[n][m]).append(' ');
            sb.append('\n');
        }

        System.out.print(sb);

    }

    static boolean isOut(int n, int m, int l) {
        return n < l || n + l == N || m < l || m + l == M || (n == l && m == l);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
