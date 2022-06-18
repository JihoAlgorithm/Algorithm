package boj18649;

class Main {

    public static void main(String[] args) throws Exception {

        int i, n = read(), k = read(), m = read();
        byte[] buf = new byte[k << 1];

        for (n = 1, i = 0; i < k << 1;) {
            buf[i++] = (byte) (n++ | 48);
            buf[i++] = 32;
        }

        while (m-- > 0) {
            System.out.write(buf);
            System.out.flush();
            while (System.in.read() > 32);
        }

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
