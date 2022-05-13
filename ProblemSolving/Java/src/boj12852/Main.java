package boj12852;

class Main {

    public static void main(String[] args) throws Exception {

        int N = read();

        int[] dp = new int[N + 2];
        int[] parent = new int[N + 2];

        dp[2] = 1;
        parent[2] = 1;

        for (int i = 3; i <= N; i++) {
            dp[i] = i;
            if (i % 3 == 0 && dp[i] > dp[i / 3]) {
                dp[i] = dp[i / 3];
                parent[i] = i / 3;
            }
            if (i % 2 == 0 && dp[i] > dp[i / 2]) {
                dp[i] = dp[i / 2];
                parent[i] = i / 2;
            }
            if (dp[i] > dp[i - 1]) {
                dp[i] = dp[i - 1];
                parent[i] = i - 1;
            }
            dp[i]++;
        }

        write(dp[N]);
        buffer[++index] = 10;
        while (N != 0) {
            write(N);
            buffer[++index] = 32;
            N = parent[N];
        }

        System.out.write(buffer, 0, index);

    }

    static int index = -1;
    static byte[] buffer = new byte[1 << 10];

    static void write(int n) {
        int l = n < 2 ? 1 : (int) (Math.log10(n) + 1);
        for (int i = l; i > 0; i--) {
            buffer[index + i] = (byte) (n % 10 | 48);
            n /= 10;
        }
        index += l;
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
