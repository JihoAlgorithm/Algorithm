package boj13549;

import java.util.ArrayDeque;

class Main {

    public static void main(String[] args) throws Exception {

        int N = read();
        int K = read();

        if (N >= K) {
            System.out.print(N - K);
            return;
        }

        int time = 0;
        final int MAX = K + 1;

        ArrayDeque<Integer> q0 = new ArrayDeque<>();
        ArrayDeque<Integer> q1 = new ArrayDeque<>();
        ArrayDeque<Integer> qt = null;

        boolean[] visited = new boolean[MAX + 1];

        q0.offer(N);
        visited[N] = true;

        while (!q0.isEmpty()) {

            int x, cx = q0.poll();

            if (cx == K) {
                System.out.print(time);
                break;
            }

            x = cx << 1;
            if (x <= MAX && !visited[x]) {
                visited[x] = true;
                q0.offer(x);
            }

            x = cx - 1;
            if (x >= 0 && !visited[x]) {
                visited[x] = true;
                q1.offer(x);
            }

            x = cx + 1;
            if (x <= MAX && !visited[x]) {
                visited[x] = true;
                q1.offer(x);
            }

            if (q0.isEmpty()) {
                qt = q0;
                q0 = q1;
                q1 = qt;
                time++;
            }

        }

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
