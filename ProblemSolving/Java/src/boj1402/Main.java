package boj1402;

class Main {

    public static void main(String[] args) throws Exception {
        int T = nextInt();
        while (T-- > 0) write();
        flush();
    }

    static int iidx, oidx, size, SIZE = 1 << 13;
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

    static void write() {
        if (oidx + 4 >= SIZE) flush();
        obuf[oidx++] = 'y';
        obuf[oidx++] = 'e';
        obuf[oidx++] = 's';
        obuf[oidx++] = 10;
    }

    static void flush() {
        System.out.write(obuf, 0, oidx);
        oidx = 0;
    }

}
