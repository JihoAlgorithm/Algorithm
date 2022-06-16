package boj18856;

class Main {

    public static void main(String[] args) throws Exception {
        int N = read();
        write(N);
        newLine();

        int i = 1;
        do write(i++);
        while (i < N);

        write(101);
        flush();
    }

    static int idx, SIZE = 1 << 11;
    static byte[] buf = new byte[SIZE];

    static void write(int n) {
        int l = n < 2 ? 1 : (int) (Math.log10(n) + 1);
        if (idx + l >= SIZE) flush();
        int i = idx + l;
        while (n > 0) {
            buf[--i] = (byte) (n % 10 | 48);
            n /= 10;
        }
        idx += l;
        buf[idx++] = 32;
    }

    static void newLine() {
        buf[idx - 1] = 10;
    }

    static void flush() {
        System.out.write(buf, 0, idx);
        idx = 0;
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
