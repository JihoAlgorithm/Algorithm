package boj1238;

class DoubleDijkstra {

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
    static int[] times, queue;

    static final int INF = 1_000_000;
    static final int MASK = (1 << 13) - 1;

    public static void main(String[] args) throws Exception {

        N = read();
        M = read();
        X = read();

        queue = new int[MASK + 1];

        Node[] partyGraph = new Node[N + 1];
        Node[] homeGraph = new Node[N + 1];

        for (int i = 0; i < M; i++) {
            int u = read();
            int v = read();
            int t = read();
            partyGraph[u] = new Node(v, t, partyGraph[u]);
            homeGraph[v] = new Node(u, t, homeGraph[v]);
        }

        int[] partyTimes = dijkstra(X, partyGraph);
        int[] homeTimes = dijkstra(X, homeGraph);

        int max = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, partyTimes[i] + homeTimes[i]);
        }

        System.out.print(max);

    }

    static int[] dijkstra(int u, Node[] graph) {

        int[] times = new int[N + 1];
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

        return times;

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3 ) + (n << 1) + (c & 15);
        return n;
    }
}
