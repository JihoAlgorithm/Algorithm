package boj17071;

import java.util.ArrayDeque;

class Main {

    static final int MAX = 500_000;

    static ArrayDeque<Integer> queue;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {

        int N = read();
        int K = read();
        int acc = 0;
        int time = 0;

        queue = new ArrayDeque<>();
        visited = new boolean[2][MAX + 1];

        queue.offer(N);

        while (!queue.isEmpty()) {

            int size = queue.size();
            
            while (size-- > 0) {

                int x = queue.poll();
                int t = (time + 1) & 1;

                if (x == K || visited[t ^ 1][K]) {
                    System.out.println(time);
                    return;
                }

                offer(t, x + 1);
                offer(t, x - 1);
                offer(t, x << 1);

            }

            if ((K += ++acc) > MAX) break;
            time++;

        }

        System.out.println(-1);

    }

    static void offer(int t, int x) {
        if (0 <= x && x <= MAX && !visited[t][x]) {
            visited[t][x] = true;
            queue.offer(x);
        }
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n <<1) + (c & 15);
        return n;
    }

}
