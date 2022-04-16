package boj6064;

class Main {

    public static void main(String[] args) throws Exception {

        StringBuilder sb = new StringBuilder();

        for (int T = nextInt(); T > 0; T--) {

            int M = nextInt();
            int N = nextInt();
            int x = nextInt() - 1;
            int y = nextInt() - 1;

            int max = M * N;
            int ans = -1;

            for (int k = x; k < max; k += M) {
                if (k % N == y) {
                    ans = k + 1;
                    break;
                }
            }

            sb.append(ans).append('\n');

        }

        System.out.print(sb);

    }

    static final int BUFFER_SIZE = 1 << 13;
    static byte[] buffer = new byte[BUFFER_SIZE];
    static int bufferIndex, bufferSize;

    static int nextInt() throws Exception {
        int n = 0;
        byte c;
        while ((c = read()) <= 32);
        do n = (n << 3) + (n << 1) + (c & 15);
        while (isNumber(c = read()));
        return n;
    }

    static boolean isNumber(byte c) {
        return 47 < c && c < 58;
    }

    static byte read() throws Exception {
        if (bufferIndex == bufferSize) {
            bufferSize = System.in.read(buffer, bufferIndex = 0, BUFFER_SIZE);
            if (bufferSize < 0) buffer[0] = -1;
        }
        return buffer[bufferIndex++];
    }

}
