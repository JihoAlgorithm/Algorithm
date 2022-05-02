package boj1504;

class Main {

    static class Node {
        int i;
        int d;
        Node next;
        Node(int i, int d, Node next) {
            this.i = i;
            this.d = d;
            this.next = next;
        }
    }

    static final int INF = 1 << 29;
    static final int MASK = (1 << 13) - 1;

    static int N;
    static Node[] graph;
    static int[] dist;
    static int[] queue = new int[MASK + 1];

    public static void main(String[] args) throws Exception {

        N = read();
        int E = read();

        graph = new Node[N + 1];
        dist = new int[N + 1];

        for (int i = 0; i < E; i++) {
            int u = read();
            int v = read();
            int d = read();

            graph[u] = new Node(v, d, graph[u]);
            graph[v] = new Node(u, d, graph[v]);
        }

        int v1 = read();
        int v2 = read();

        dijkstra(1);
        int sv1 = dist[v1];
        int sv2 = dist[v2];

        dijkstra(v1);
        int v1e = dist[N];
        int mid = dist[v2];

        dijkstra(v2);
        int v2e = dist[N];

        int min = INF;
        min = Math.min(min, sv1 + mid + v2e);
        min = Math.min(min, sv2 + mid + v1e);

        System.out.print(min >= INF ? -1 : min);

    }

    static void dijkstra(int start) {
        for (int i = 1; i <= N; i++) dist[i] = INF;

        int head = -1;
        int tail = -1;

        dist[start] = 0;
        queue[++head] = start;

        while (head > tail) {
            int u = queue[++tail & MASK];

            for (Node node = graph[u]; node != null; node = node.next) {
                int v = node.i;
                int d = dist[u] + node.d;
                if (dist[v] > d) {
                    dist[v] = d;
                    queue[++head & MASK] = v;
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
