package boj16104;

class Main {

    public static void main(String[] args) throws Exception {

        int n = read();
        int m = n / 2;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                write(i);
                write(((i + j) % n) + 1);
                newLine();
            }
        }

        flush();

    }

    static int oidx, SIZE = 1 << 13;
    static byte[] buf = new byte[SIZE];

    static void write(int n) {
        int l = n <= 1 ? 1 : ((int) Math.log10(n) + 1);
        if (oidx + l + 1 >= SIZE) flush();
        int i = oidx + l;
        do {
            buf[--i] = (byte) (n % 10 | 48);
            n /= 10;
        } while (n > 0);
        oidx += l;
        buf[oidx++] = 32;
    }

    static void newLine() {
        buf[oidx - 1] = 10;
    }

    static void flush() {
        System.out.write(buf, 0, oidx);
        oidx = 0;
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
