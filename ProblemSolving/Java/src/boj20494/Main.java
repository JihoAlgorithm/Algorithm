package boj20494;

class Main {

    static int sushi, idx, size, SIZE = 1 << 13;
    static byte[] buf = new byte[SIZE];

    public static void main(String[] args) throws Exception {
        int N = nextInt();
        while (N-- > 0) nextOrder();
        System.out.print(sushi);
    }

    static int nextInt() throws Exception {
        int n = 0;
        byte c;
        while ((c = read()) <= 32);
        do n = (n << 3) + (n << 1) + (c & 15);
        while (47 < (c = read()) && c < 58);
        return n;
    }

    static void nextOrder() throws Exception {
        while (read() > 10) sushi++;
    }

    static byte read() throws Exception {
        if (size == idx) {
            size = System.in.read(buf, idx = 0, SIZE);
            if (size < 0) buf[0] = -1;
        }
        return buf[idx++];
    }

}
