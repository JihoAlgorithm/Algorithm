package boj13172;

class Main {

    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {

        int M = read();
        int sum = 0;

        for (int i = 0; i < M; i++) {

            int N = read();
            int S = read();
            int gcd = gcd(N, S);

            sum += expectedValue(N / gcd, S / gcd);
            sum %= MOD;

        }

        System.out.print(sum);

    }

    static long expectedValue(int n, int s) {
        return s * pow(n, MOD - 2) % MOD;
    }

    static long pow(long n, int p) {
        long r = 1;
        while (p > 0) {
            if ((p & 1) == 1) r = r * n % MOD;
            n = n * n % MOD;
            p >>= 1;
        }
        return r;
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
