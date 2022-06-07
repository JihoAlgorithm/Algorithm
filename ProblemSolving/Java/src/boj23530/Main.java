package boj23530;

class Main {

    public static void main(String[] args) throws Exception {
        int t = nextInt();
        while (t-- > 0) write(nextInt() + nextInt() == 2);
        flush();
    }

    static int iidx, oidx, size, SIZE = 1 << 9;
    static byte[] ibuf = new byte[SIZE];
    static byte[] obuf = new byte[SIZE];

    static void write(boolean isTwo) {
        if (oidx + 2 >= SIZE) flush();
        obuf[oidx++] = (byte) (isTwo ? 49 : 50);
        obuf[oidx++] = 10;
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

}
