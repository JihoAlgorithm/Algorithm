package boj1107;

import java.util.ArrayDeque;

class Fail {

    static final int MAX = 1_000_000;

    static int N, M;
    static int[] button, count;
    static ArrayDeque<Integer> queue;

    public static void main(String[] args) throws Exception {

        N = read();
        M = read();

        if (N == 100) {
            System.out.print(0);
            return;
        }

        boolean[] buttonStatus = new boolean[10];
        for (int i = 0; i < M; i++) buttonStatus[read()] = true;

        int normalIndex = 0;
        M = 10 - M;
        button = new int[M];
        for (int i = 0; i < 10; i++)
            if (!buttonStatus[i]) button[normalIndex++] = i;

        count = new int[MAX + 1];
        queue = new ArrayDeque<>();

        combination(0, 0);
        queue.offer(100);
        count[100] = 0;
        if (count[N] == 0) bfs();

        System.out.print(count[N]);

    }

    static void bfs() {

        while (!queue.isEmpty()) {

            int n = queue.poll();
            int c = count[n];
            if (n == N) break;

            int nn, cc = c + 1;

            nn = n + 1;
            if (nn <= MAX) {
                if (count[nn] == 0 || count[nn] > cc) {
                    count[nn] = cc;
                    queue.offer(nn);
                }
            }

            nn = n - 1;
            if (nn >= 0) {
                if (count[nn] == 0 || count[nn] > cc) {
                    count[nn] = cc;
                    queue.offer(nn);
                }
            }

        }

    }

    static void combination(int c, int n) {
        for (int i = 0; i < M; i++) {
            int nn = (n << 3) + (n << 1) + button[i];
            if (nn > MAX) continue;
            if (nn > N << 1) continue;
            if (count[nn] == 0 || count[nn] > c + 1) {
                count[nn] = c + 1;
                queue.offer(nn);
                combination(c + 1, nn);
            }
        }
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
