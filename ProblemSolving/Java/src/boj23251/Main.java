package boj23251;

class Main {

    public static void main(String[] args) throws Exception {
        int T = nextInt();
        while (T-- > 0) {
            int iu23 = nextInt();
            iu23 += (iu23 << 4) + (iu23 << 2) + (iu23 << 1);
            write(iu23);
        }
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
        if (size == iidx) {
            size = System.in.read(ibuf, iidx = 0, SIZE);
            if (size < 0) ibuf[0] = -1;
        }
        return ibuf[iidx++];
    }

    static void write(long iu23) {
        int l = iu23 < 2 ? 1 : (int) Math.log10(iu23) + 1;
        if (l + oidx >= SIZE) flush();
        l = oidx += l;
        while (iu23 > 0) {
            obuf[--l] = (byte) (iu23 % 10 | 48);
            iu23 /= 10;
        }
        obuf[oidx++] = 10;
    }

    static void flush() {
        System.out.write(obuf, 0, oidx);
        oidx = 0;
    }

}
