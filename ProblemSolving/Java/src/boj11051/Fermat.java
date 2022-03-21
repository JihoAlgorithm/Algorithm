package boj11051;

class Fermat {

    static long[] factorial;
    static final int MOD = 10_007;

    public static void main(String[] args) throws Exception {

        int N = read();
        int K = read();
        factorial = new long[N + 1];
        factorial[0] = factorial[1] = 1L;

        long a = factorial(N);
        long b = factorial(K) * factorial(N - K) % MOD;
        long c = a * littleLawOfFermat(b, MOD - 2) % MOD;

        System.out.print(c);

    }

    static long factorial(int n) {
        if (factorial[n] > 0) return factorial[n];
        factorial[n] = n * factorial(n - 1);
        return factorial[n] %= MOD;
    }

    static long littleLawOfFermat(long a, int p) {

        long n = 1L;

        while (p > 0) {

            if ((p & 1) == 1) {
                n *= a;
                n %= MOD;
            }

            a *= a;
            a %= MOD;
            p >>= 1;

        }

        return n;

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
