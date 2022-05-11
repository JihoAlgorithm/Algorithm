package boj11779;

class Main {

    static class Node {
        int v;
        long c;
        Node n;
        Node(int v, long c, Node n) {
            this.v = v;
            this.c = c;
            this.n = n;
        }
    }

    static class Reader {
        final int SIZE = 1 << 13;
        byte[] buffer = new byte[SIZE];
        int size, index;
        int next() throws Exception {
            int n = 0;
            byte c;
            while ((c = read()) <= 32);
            do n = (n << 3) + (n << 1) + (c & 15);
            while (isNumber(c = read()));
            return n;
        }
        byte read() throws Exception {
            if (index == size) {
                size = System.in.read(buffer, index = 0, SIZE);
                if (size < 0) buffer[0] = -1;
            }
            return buffer[index++];
        }
        boolean isNumber(byte c) {
            return 47 < c && c < 58;
        }
    }

    static class Writer {
        final int SIZE = 1 << 19;
        byte[] buffer = new byte[SIZE];
        int size, index = SIZE;
        void write(long n) {
            int len = n == 0 ? 1 : (int) Math.log10(n) + 1;
            while (len-- > 0) {
                buffer[--index] = (byte) (n % 10 | 48);
                n /= 10;
            }
        }
        void space() {
            buffer[--index] = 32;
        }
        void newLine() {
            buffer[index] = 10;
        }
        void flush() {
            System.out.write(buffer, index, SIZE - index);
        }
    }

    static int N, M;
    static Node[] graph;
    static long[] cost;
    static int[] parent;

    static final long INF = -1L >>> 1;

    public static void main(String[] args) throws Exception {

        Reader in = new Reader();

        N = in.next();
        M = in.next();
        graph = new Node[N + 1];

        for (int i = 0; i < M; i++) {
            int u = in.next();
            int v = in.next();
            int c = in.next();
            graph[u] = new Node(v, c, graph[u]);
        }

        int start = in.next();
        int end = in.next();
        dijkstra(start, end);

        Writer out = new Writer();
        int via = 0;
        int p = end;
        while (p != start) {
            via++;
            out.write(p);
            out.space();
            p = parent[p];
        }
        out.write(p);
        out.space();
        out.newLine();
        out.write(++via);
        out.space();
        out.newLine();
        out.write(cost[end]);

        out.flush();

    }

    static void dijkstra(int start, int end) {

        cost = new long[N + 1];
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            cost[i] = INF;
            parent[i] = i;
        }

        Heap pq = new Heap();
        boolean[] visited = new boolean[N + 1];

        cost[start] = 0;
        pq.offer(start, 0);

        while (!pq.isEmpty()) {
            int u = Heap.getU(pq.poll());
            if (visited[u]) continue;
            visited[u] = true;
            for (Node node = graph[u]; node != null; node = node.n) {
                int v = node.v;
                long c = node.c + cost[u];
                if (cost[v] > c) {
                    cost[v] = c;
                    parent[v] = u;
                    pq.offer(v, c);
                }
            }
        }

    }

    static class Heap {
        static final int BIT = 10;
        static final int MASK = (1 << BIT) - 1;
        long[] heap = new long[MASK];
        int size;
        boolean isEmpty() {
            return size == 0;
        }
        static int getU(long value) {
            return (int) (value & MASK);
        }
        long encode(int v, long c) {
            return c << BIT | v;
        }
        void offer(int v, long c) {
            heap[++size] = encode(v, c);
            int i = size << 1;
            while ((i >>= 1) > 1) {
                if (!swap(i)) break;
            }
        }
        long poll() {
            long e = heap[1];
            heap[1] = heap[size--];
            int i = 1;
            while ((i <<= 1) <= size) {
                if (i < size && heap[i + 1] < heap[i]) i++;
                if (!swap(i)) break;
            }
            return e;
        }
        boolean swap(int i) {
            int j = i >> 1;
            long p = heap[j];
            long c = heap[i];
            if (p < c) return false;
            heap[i] = p;
            heap[j] = c;
            return true;
        }
    }

}
