package boj12400;

class Main {

    static int idx, gidx, size, SIZE = 1 << 13;
    static byte[] buf = new byte[SIZE];
    static byte[] G = new byte[SIZE];

    static byte[] mapper = {
        ' ', 'y', 'h', 'e', 's', 'o', 'c', 'v', 'x',
        'd', 'u', 'i', 'g', 'l', 'b', 'k', 'r', 'z',
        't', 'n', 'w', 'j', 'p', 'f', 'm', 'a', 'q'
    };

    public static void main(String[] args) throws Exception {
        int T = nextInt();
        for (int X = 1; X <= T; X++) {
            writeHeader(X);
            nextG();
        }
        flush();
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
        if (idx == size) {
            size = System.in.read(buf, idx = 0, SIZE);
            if (size < 0) buf[0] = -1;
        }
        return buf[idx++];
    }

    static void nextG() throws Exception {
        if (gidx + 101 >= SIZE) flush();
        byte c;
        while ((c = read()) > 10) G[gidx++] = mapper[c & 31];
        G[gidx++] = 10;
    }

    static void writeHeader(int X) {
        if (gidx + 11 >= SIZE) flush();
        G[gidx++] = 'C';
        G[gidx++] = 'a';
        G[gidx++] = 's';
        G[gidx++] = 'e';
        G[gidx++] = ' ';
        G[gidx++] = '#';
        if (X > 9) {
            G[gidx++] = (byte) (X / 10 | 48);
            G[gidx++] = (byte) (X % 10 | 48);
        } else {
            G[gidx++] = (byte) (X | 48);
        }
        G[gidx++] = ':';
        G[gidx++] = ' ';
    }

    static void flush() {
        System.out.write(G, 0, gidx);
        gidx = 0;
    }

}
