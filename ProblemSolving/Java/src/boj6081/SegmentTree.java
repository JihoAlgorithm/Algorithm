package boj6081;

class SegmentTree {

    public static void main(String[] args) throws Exception {

        int N = FastIO.nextInt();
        int Q = FastIO.nextInt();

        int[] hayBales = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            hayBales[i] = FastIO.nextInt();
        }

        Tree tree = new Tree(hayBales, N);
        int S, E;
        for (int q = 0; q < Q; q++) {
            S = FastIO.nextInt();
            E = FastIO.nextInt();
            FastIO.write(tree.get(0, N, 1, S, E));
            FastIO.newLine();
        }

        FastIO.flush();

    }

    static class Tree {

        int[] tree;
        int[] arr;

        Tree(int[] arr, int size) {
            this.tree = new int[(size << 2) + 1];
            this.arr = arr;
            init(0, size, 1);
        }

        int init(int s, int e, int i) {
            if (s == e) return tree[i] = arr[s];
            int m = s + e >> 1;
            return tree[i] = init(s, m, i <<= 1) + init(m + 1, e, i + 1);
        }

        int get(int s, int e, int i, int l, int r) {
            if (l > e || r < s) return 0;
            if (l <= s && r >= e) return tree[i];
            int m = s + e >> 1;
            return get(s, m, i <<= 1, l, r) + get(m + 1, e, i + 1, l, r);
        }

    }

    static class FastIO {

        private static final int SIZE = 1 << 13;

        static int iidx, oidx, size;
        static byte[] ibuf = new byte[SIZE];
        static byte[] obuf = new byte[SIZE];

        static int nextInt() throws Exception {
            int n = 0;
            byte c;
            while ((c = read()) <= 32);
            do n = (n << 3) + (n << 1) + (c & 15);
            while (47 < (c = read()) && c < 58);
            return n;
        }

        static byte read() throws Exception {
            if (iidx == size) {
                size = System.in.read(ibuf, iidx = 0, SIZE);
                if (size < 0) ibuf[0] = -1;
            }
            return ibuf[iidx++];
        }

        static void write(int n) {
            int l = n <= 1 ? 1 : (int) (Math.log10(n) + 1);
            if (oidx + l >= SIZE) flush();
            oidx += l;
            for (int i = 1; i <= l; i++) {
                obuf[oidx - i] = (byte) (n % 10 | 48);
                n /= 10;
            }
            obuf[oidx++] = 32;
        }

        static void newLine() {
            obuf[oidx - 1] = 10;
        }

        static void flush() {
            System.out.write(obuf, 0, oidx);
            oidx = 0;
        }

    }

}
