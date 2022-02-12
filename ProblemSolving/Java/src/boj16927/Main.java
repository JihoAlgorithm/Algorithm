package boj16927;

import java.util.*;

class Main {

    static int N, M, R, numberOfCircles;
    static int circumference[];

    public static void main(String[] args) throws Exception {

        N = read();
        M = read();
        R = read();
        numberOfCircles = Math.min(N, M) >> 1;
        circumference = new int[numberOfCircles];

        for (int i = 0; i < numberOfCircles; i++)
            circumference[i] = (N + M - 2- (i << 2)) << 1;

        List<Queue<Integer>> queues = new ArrayList<>(numberOfCircles);
        for (int i = 0; i < numberOfCircles; i++) queues.add(new LinkedList<>());

        int[][] array = new int[N][M];
        for (int n = 0; n < N; n++)
            for (int m = 0; m < M; m++)
                array[n][m] = read();

        for (int c = 0; c < numberOfCircles; c++) {
            Queue<Integer> queue = queues.get(c);
            for (int t = c; t < M - c - 1; t++) queue.offer(array[c][t]);
            for (int r = c; r < N - c - 1; r++) queue.offer(array[r][M - c - 1]);
            for (int b = M - c - 1; b > c; b--) queue.offer(array[N - c - 1][b]);
            for (int l = N - c - 1; l > c; l--) queue.offer(array[l][c]);
        }

        for (int c = 0; c < numberOfCircles; c++) {
            Queue<Integer> queue = queues.get(c);
            int round = R % circumference[c];
            while (round-- > 0) queue.offer(queue.poll());
        }

        for (int c = 0; c < numberOfCircles; c++) {
            Queue<Integer> queue = queues.get(c);
            for (int t = c; t < M - c - 1; t++) array[c][t] = queue.poll();
            for (int r = c; r < N - c - 1; r++) array[r][M - c - 1] = queue.poll();
            for (int b = M - c - 1; b > c; b--) array[N - c - 1][b] = queue.poll();
            for (int l = N - c - 1; l > c; l--) array[l][c] = queue.poll();
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
