package boj16260;

class Main {

    public static void main(String[] args) throws Exception {

        int t = nextInt();
        int[][] seats = new int[21][21];

        while (t-- > 0) {
            int n = nextInt();
            int m = nextInt();

            int i = 1;
            int nm = n * m;

            int diagonal = n + m - 1;
            int d = -1;

            while (i <= nm && ++d < diagonal) {
                int r = d < m ? n : diagonal - d;
                int s = d < m ? m - d : 1;
                while (s <= m && r > 0) seats[r--][s++] = i++;
            }

            for (int r = 1; r <= n; r++) {
                for (int s = 1; s <= m; s++) {
                    write(seats[r][s]);
                }
                newLine();
            }
        }

        flush();

    }

    static int iidx, oidx, size, SIZE = 1 << 13;
    static byte[] ibuf = new byte[SIZE];
    static byte[] obuf = new byte[SIZE];

    static void write(int n) {
        int l = n <= 1 ? 1 : ((int) Math.log10(n) + 1);
        if (oidx + l >= SIZE) flush();
        int i = oidx + l;
        while (n > 0) {
            obuf[--i] = (byte) (n % 10 | 48);
            n /= 10;
        }
        oidx += l;
        obuf[oidx++] = 32;
    }

    static void newLine() {
        obuf[oidx - 1] = 10;
    }

    static void flush() {
        System.out.write(obuf, 0, oidx);
        oidx = 0;
    }

    static int nextInt() throws Exception {
        int n = 0;
        byte c;
        while ((c = read()) <= 32);
        do n = (n << 3) + (n << 1) + (c & 15);
        while ((c = read()) > 32);
        return n;
    }

    static byte read() throws Exception {
        if (iidx == size) {
            size = System.in.read(ibuf, iidx = 0, SIZE);
            if (size < 0) ibuf[0] = -1;
        }
        return ibuf[iidx++];
    }

}
