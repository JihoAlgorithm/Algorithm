package boj13322;

class Main {

    public static void main(String[] args) throws Exception {

        int i = 0;

        while (true) {
            int size = System.in.read(ibuf);
            if (size < 0) break;
            if (ibuf[size - 1] == 10) size--;
            while (size-- > 0) write(i++);
        }

        flush();

    }

    static int oidx, SIZE = 1 << 13;
    static byte[] ibuf = new byte[SIZE];
    static byte[] obuf = new byte[SIZE];

    static void write(int n) {
        int l = n < 2 ? 1 : (int) (Math.log10(n) + 1);
        if (oidx + l >= SIZE) flush();
        l = oidx += l;
        do {
            obuf[--l] = (byte) (n % 10 | 48);
            n /= 10;
        } while (n > 0);
        obuf[oidx++] = 10;
    }

    static void flush() {
        System.out.write(obuf, 0, oidx);
        oidx = 0;
    }

}
