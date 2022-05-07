package boj14938;

class Main {

    static class Node {
        int v;
        int d;
        Node next;
        Node(int v, int d, Node next) {
            this.v = v;
            this.d = d;
            this.next = next;
        }
    }

    static class Queue {
        static final int MASK = (1 << 13) - 1;
        int[] queue;
        int head;
        int tail;
        Queue() {
            queue = new int[MASK + 1];
            clear();
        }
        void clear() {
            head = tail = -1;
        }
        boolean isEmpty() {
            return head == tail;
        }
        void offer(int e) {
            queue[++head & MASK] = e;
        }
        int poll() {
            return queue[++tail & MASK];
        }
    }

    static int N, M, R;
    static int[] items;
    static Node[] graph;
    static Queue queue;

    public static void main(String[] args) throws Exception {

        N = read();
        M = read() + 1;
        R = read();

        items = new int[N + 1];
        for (int i = 1; i <= N; i++) items[i] = read();

        graph = new Node[N + 1];
        for (int r = 0; r < R; r++) {
            int u = read();
            int v = read();
            int d = read();
            graph[u] = new Node(v, d, graph[u]);
            graph[v] = new Node(u, d, graph[v]);
        }

        int max = 0;
        queue = new Queue();
        for (int n = 1; n <= N; n++) {
            max = Math.max(max, bfs(n));
        }

        System.out.print(max);

    }

    static int bfs(int start) {
        int item = 0;

        int[] dist = new int[N + 1];
        for (int i = 1; i <= N; i++) dist[i] = M;

        queue.clear();
        queue.offer(start);
        dist[start] = 0;

        while (!queue.isEmpty()) {

            int u = queue.poll();

            for (Node node = graph[u]; node != null; node = node.next) {
                int v = node.v;
                int d = node.d + dist[u];
                if (dist[v] > d && M > d) {
                    dist[v] = d;
                    queue.offer(v);
                }
            }

        }

        for (int i = 1; i <= N; i++) {
            if (dist[i] < M) {
                item += items[i];
            }
        }

        return item;
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
