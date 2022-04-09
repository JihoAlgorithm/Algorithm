package boj11724;

public class DataInputStreamTest {

    static Reader in;
    static int[] set;

    public static void main(String[] args) throws Exception {

        in = new Reader();

        int N = in.nextInt();
        int M = in.nextInt();
        int connectedComponent = N;

        initDisjointSet(N);

        while (M-- > 0)
            if (union(in.nextInt(), in.nextInt()))
                if (--connectedComponent == 1) break;

        System.out.print(connectedComponent);

    }

    static void initDisjointSet(int N) {
        set = new int[N + 1];
        while (N-- > 0) set[N] = -1;
    }

    static boolean union(int u, int v) {

        if ((u = find(u)) == (v = find(v)))
            return false;

        if (set[u] < set[v]) {
            set[u] += set[v];
            set[v] = u;
        } else {
            set[v] += set[u];
            set[u] = v;
        }

        return true;
    }

    static int find(int u) {
        return set[u] < 0 ? u : (set[u] = find(set[u]));
    }

    static class Reader {

        private final int BUFFER_SIZE = 1 << 13;
        private byte[] buffer;
        private int index, size;

        public Reader() {
            buffer = new byte[BUFFER_SIZE];
            index = size = 0;
        }

        public int nextInt() throws Exception {
            int n = 0;
            byte c;

            while ((c = read()) <= 32);

            do {
                n = (n << 3) + (n << 1) + (c & 15);
                c = read();
            } while (47 < c && c < 58);

            return n;
        }

        private byte read() throws Exception {
            if (index == size) {
                size = System.in.read(buffer, index = 0, BUFFER_SIZE);
                if (size == -1) buffer[0] = -1;
            }

            return buffer[index++];
        }
    }

}
