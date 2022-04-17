package boj16928;

import java.util.ArrayDeque;

class Main {

    public static void main(String[] args) throws Exception {

        int time = 0;

        int N = read();
        int M = read();

        int[] graph = new int[101];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[101];

        while (N-- > 0) graph[read()] = read();
        while (M-- > 0) graph[read()] = read();

        visited[1] = true;
        queue.offer(1);

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {
                int u = queue.poll();

                if (u == 100) {
                    System.out.print(time);
                    return;
                }

                int v = graph[u];
                if (v > 0) visited[u = v] = true;

                for (v = u + 6; v > u; v--) {
                    if (v > 100 || visited[v]) continue;
                    visited[v] = true;
                    queue.offer(v);
                }
            }

            time++;

        }

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
