package boj11659;

class Main {

    public static void main(String[] args) throws Exception {

        int N = nextInt();
        int M = nextInt();
        int[] dp = new int[N + 1];
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) dp[i] = dp[i - 1] + nextInt();

        for (int k = 0; k < M; k++) {
            int i = nextInt();
            int j = nextInt();
            sb.append(dp[j] - dp[i - 1]).append('\n');
        }

        System.out.print(sb);

    }

    static final int BUFFER_SIZE = 1 << 14;
    static byte[] buffer = new byte[BUFFER_SIZE];
    static int bufferIndex, bufferLength;

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
        if (bufferIndex == bufferLength) {
            bufferLength = System.in.read(buffer, bufferIndex = 0, BUFFER_SIZE);
            if (bufferLength == -1) buffer[0] = -1;
        }
        return buffer[bufferIndex++];
    }

}
