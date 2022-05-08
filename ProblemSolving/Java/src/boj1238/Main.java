package boj1238;

class Main {

    static class Node {
        int v;
        int t;
        Node n;
        Node(int v, int t, Node n) {
            this.v = v;
            this.t = t;
            this.n = n;
        }
    }

    static int N, M, X;
    static Node[] graph;
    static int[] times, queue;

    static final int INF = 1_000_000;
    static final int MASK = (1 << 13) - 1;

    public static void main(String[] args) throws Exception {

        N = read();
        M = read();
        X = read();

        queue = new int[MASK + 1];

        graph = new Node[N + 1];
        for (int i = 0; i < M; i++) {
            int u = read();
            int v = read();
            int t = read();
            graph[u] = new Node(v, t, graph[u]);
        }

        int[] roundTime = new int[N + 1];
        times = new int[N + 1];

        dijkstra(X);
        for (int i = 1; i <= N; i++) {
            roundTime[i] = times[i];
        }

        for (int i = 1; i <= N; i++) {
            roundTime[i] += dijkstra(i);
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, roundTime[i]);
        }

        System.out.print(max);

    }

    static int dijkstra(int u) {
        for (int i = 1; i <= N; i++) times[i] = INF;

        int head = -1;
        int tail = -1;

        queue[++head] = u;
        times[u] = 0;

        while (head > tail) {

            u = queue[++tail & MASK];

            for (Node node = graph[u]; node != null; node = node.n) {
                int v = node.v;
                int t = node.t + times[u];
                if (times[v] > t) {
                    times[v] = t;
                    queue[++head & MASK] = v;
                }
            }

        }

        return times[X];

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3 ) + (n << 1) + (c & 15);
        return n;
    }
}
