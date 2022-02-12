package boj16927;

import java.util.*;

class Vector {

    static int N, M, R, numberOfCircles;
    static int circumference[];
    static final int[] dn = {0, 1, 0, -1};
    static final int[] dm = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {

        N = read();
        M = read();
        R = read();
        numberOfCircles = Math.min(N, M) >> 1;
        circumference = new int[numberOfCircles];

        for (int i = 0; i < numberOfCircles; i++)
            circumference[i] = (N + M - 2 - (i << 2)) << 1;

        List<Queue<Integer>> queues = new ArrayList<>(numberOfCircles);
        for (int i = 0; i < numberOfCircles; i++) queues.add(new LinkedList<>());

        int[][] array = new int[N][M];
        for (int n = 0; n < N; n++)
            for (int m = 0; m < M; m++)
                array[n][m] = read();

        for (int c = 0; c < numberOfCircles; c++) {
            Queue<Integer> queue = queues.get(c);
            int n, m;
            n = m = c;
            queue.offer(array[n][m]);
            for (int d = 0; d < 4; d++) {
                while (true) {
                    n += dn[d];
                    m += dm[d];
                    if (n < c || n + c == N || m < c || m + c == M || (n == c && m == c)) {
                        n -= dn[d];
                        m -= dm[d];
                        break;
                    }
                    queue.offer(array[n][m]);
                }
            }
        }

        for (int c = 0; c < numberOfCircles; c++) {
            Queue<Integer> queue = queues.get(c);
            int round = R % circumference[c];
            while (round-- > 0) queue.offer(queue.poll());
        }

        for (int c = 0; c < numberOfCircles; c++) {
            Queue<Integer> queue = queues.get(c);
            int n, m;
            n = m = c;
            array[n][m] = queue.poll();
            for (int d = 0; d < 4; d++) {
                while (true) {
                    n += dn[d];
                    m += dm[d];
                    if (n < c || n + c == N || m < c || m + c == M || (n == c && m == c)) {
                        if (n == c && m == c) break;
                        n -= dn[d];
                        m -= dm[d];
                        break;
                    }
                    array[n][m] = queue.poll();
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

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
