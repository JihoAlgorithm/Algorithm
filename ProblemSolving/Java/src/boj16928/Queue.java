package boj16928;

class Queue {

    public static void main(String[] args) throws Exception {

        int time = 0;

        int N = read();
        int M = read();

        int[] graph = new int[101];
        boolean[] visited = new boolean[101];

        final int MASK = 1023;
        int[] queue = new int[MASK + 1];
        int head = -1;
        int tail = -1;

        while (N-- > 0) graph[read()] = read();
        while (M-- > 0) graph[read()] = read();

        visited[1] = true;
        queue[++tail] = 1;

        while (head < tail) {

            int size = tail - head;

            while (size-- > 0) {
                int u = queue[++head & MASK];

                if (u == 100) {
                    System.out.print(time);
                    return;
                }

                int v = graph[u];
                if (v > 0) visited[u = v] = true;

                for (v = u + 6; v > u; v--) {
                    if (v > 100 || visited[v]) continue;
                    visited[v] = true;
                    queue[++tail & MASK] = v;
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
