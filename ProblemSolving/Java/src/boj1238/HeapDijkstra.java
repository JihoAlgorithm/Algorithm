package boj1238;

class HeapDijkstra {

    static int N, M, X;
    static int[] times;
    static Heap pq;
    static boolean[] visited;

    static final int INF = 1_000_000;
    static final int MASK = (1 << 13) - 1;

    public static void main(String[] args) throws Exception {

        N = read();
        M = read();
        X = read();

        pq = new Heap();
        visited = new boolean[N + 1];

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
        for (int i = 1; i <= N; i++) {
            times[i] = INF;
            visited[i] = false;
        }

        pq.offer(u, 0);
        times[u] = 0;

        while (!pq.isEmpty()) {

            int value = pq.poll();
            u = Heap.getV(value);

            if (visited[u]) continue;
            visited[u] = true;

            for (Node node = graph[u]; node != null; node = node.n) {
                int v = node.v;
                int t = node.t + times[u];
                if (times[v] > t) {
                    times[v] = t;
                    pq.offer(v, t);
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

class Node {
    int v;
    int t;
    Node n;
    Node(int v, int t, Node n) {
        this.v = v;
        this.t = t;
        this.n = n;
    }
}

class Heap {

    static final int SIZE = 2000;
    static final int BIT = 10;
    static final int MASK = (1 << BIT) - 1;

    int[] heap = new int[SIZE + 1];
    int size;

    static int getV(int value) {
        return value & MASK;
    }

    static int getT(int value) {
        return value >> BIT;
    }

    boolean isEmpty() {
        return size == 0;
    }

    void offer(int v, int t) {
        heap[++size] = t << BIT | v;
        int i = size << 1;
        while ((i >>= 1) > 1)
            if (!swap(i)) break;
    }

    int poll() {
        int i = 1;
        int value = heap[i];
        heap[i] = heap[size--];

        while ((i <<= 1) <= size) {
            if (i < size && heap[i + 1] < heap[i]) i++;
            if (!swap(i)) break;
        }

        return value;
    }

    boolean swap(int i) {
        int j = i >> 1;

        int p = heap[j];
        int c = heap[i];

        if (p < c) return false;

        heap[i] = p;
        heap[j] = c;

        return true;
    }

}
