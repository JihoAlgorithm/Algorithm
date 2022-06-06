package boj19155;

class Main {

    public static void main(String[] args) throws Exception {

        int N = FastIO.nextInt() + 1;

        for (int i = 1; i < N; i++)
            FastIO.write(N - FastIO.nextInt());

        FastIO.flush();

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
