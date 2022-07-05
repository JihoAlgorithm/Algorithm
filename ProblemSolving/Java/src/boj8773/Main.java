package boj8773;

class Main {

    public static void main(String[] args) throws Exception {

        int Z = nextInt();
        int[] cornelia = new int[2_000_000];
        StringBuilder sb = new StringBuilder();

        while (Z-- > 0) {
            int N = nextInt();
            int M = nextInt();
            int size = N << 1;

            for (int i = 0; i < N; i++) {
                cornelia[i] = cornelia[size - i - 1] = nextInt();
            }

            sb.append(cornelia[M % size]).append('\n');
        }

        System.out.print(sb);

    }

    static int idx, size, SIZE = 1 << 13;
    static byte[] buf = new byte[SIZE];

    static int nextInt() throws Exception {
        int n = 0;
        byte c;
        while ((c = read()) <= 32);
        do n = (n << 3) + (n << 1) + (c & 15);
        while (47 < (c = read()) && c < 58);
        return n;
    }

    static byte read() throws Exception {
        if (size == idx) {
            size = System.in.read(buf, idx = 0, SIZE);
            if (size < 0) buf[0] = -1;
        }
        return buf[idx++];
    }

}
