package boj1865;

class Main {

    static final byte[] YES = new byte[]{'Y', 'E', 'S', '\n'};
    static final byte[] NO = new byte[]{'N', 'O', '\n'};

    public static void main(String[] args) throws Exception {
        for (int i = read(); i > 0; i--) System.out.write(testcase());
        System.out.close();
    }

    static int N, M, W;
    static Node[] graph;
    static int[] times = new int[501];
    static boolean[] visited = new boolean[501];
    static final int INF = 1 << 29;

    static final int MASK = (1 << 13) - 1;
    static int[] queue = new int[MASK + 1];

    static class Node {
        int e;
        int t;
        Node n;
        Node(int e, int t, Node n) {
            this.e = e;
            this.t = t;
            this.n = n;
        }
    }

    static byte[] testcase() throws Exception {

        N = read();
        M = read();
        W = read();

        graph = new Node[N + 1];
        for (int i = 0; i < M; i++) {
            int s = read();
            int e = read();
            int t = read();
            graph[s] = new Node(e, t, graph[s]);
            graph[e] = new Node(s, t, graph[e]);
        }
        for (int i = 0; i < W; i++) {
            int s = read();
            int e = read();
            int t = read();
            graph[s] = new Node(e, -t, graph[s]);
        }

        for (int i = 1; i <= N; i++) {
            dijkstra(i);
            if (times[i] < 0) return YES;
        }

        return NO;

    }

    static void dijkstra(int start) {

        for (int i = 1; i <= N; i++) times[i] = INF;

        int head = -1;
        int tail = -1;

        times[start] = 0;
        queue[++head] = start;

        while (head > tail) {
            int s = queue[++tail & MASK];
            for (Node node = graph[s]; node != null; node = node.n) {
                int e = node.e;
                int t = node.t + times[s];
                if (times[e] > t && !visited[e]) {
                    if (times[start] < 0) return;
                    if (node.t < 0 && times[s] < 0) visited[e] = true;
                    times[e] = t;
                    queue[++head & MASK] = e;
                }
            }
        }

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
