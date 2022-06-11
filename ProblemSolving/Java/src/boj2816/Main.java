package boj2816;

class Main {

    public static void main(String[] args) throws Exception {

        int N = nextInt();
        byte[] channels = new byte[N];
        scanChannels(channels, N);

        int cursor = 0;

        while (channels[cursor] != 1) {
            cursor++;
            write(1);
        }

        while (cursor > 0) {
            byte temp = channels[cursor];
            channels[cursor] = channels[cursor - 1];
            channels[cursor - 1] = temp;
            cursor--;
            write(4);
        }

        while (channels[cursor] != 2) {
            cursor++;
            write(1);
        }

        while (cursor > 1) {
            byte temp = channels[cursor];
            channels[cursor] = channels[cursor - 1];
            channels[cursor - 1] = temp;
            cursor--;
            write(4);
        }

        flush();

    }

    static void scanChannels(byte[] channels, int size) throws Exception {
        for (int i = 0; i < size; i++) {
            channels[i] = nextChanel();
        }
    }

    static int iidx, oidx, size, SIZE = 1 << 13;
    static byte[] ibuf = new byte[SIZE];
    static byte[] obuf = new byte[SIZE];
    static byte[] cbuf = new byte[10];

    static void write(int command) {
        if (oidx == SIZE) flush();
        obuf[oidx++] = (byte) (command | 48);
    }

    static void flush() {
        System.out.write(obuf, 0, oidx);
        oidx = 0;
    }

    static byte nextChanel() throws Exception {
        int l = 0;
        byte c;
        while ((c = read()) <= 32);
        do cbuf[l++] = c;
        while ((c = read()) > 32);

        if (l > 4 || cbuf[0] != 'K' || cbuf[1] != 'B' || cbuf[2] != 'S') {
            return 0;
        }

        if (cbuf[3] == '1') return 1;
        if (cbuf[3] == '2') return 2;

        return 0;
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
