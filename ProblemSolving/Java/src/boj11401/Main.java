package boj11401;

class Main {

    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {

        int N = read();
        int K = read();

        long[] factorial = setFactorial(N);
        long denominator = factorial[N - K] * factorial[K] % MOD;
        long answer = factorial[N] * pow(denominator, MOD - 2) % MOD;

        System.out.println(answer);

    }

    static long[] setFactorial(int N) {
        long[] factorial = new long[N + 1];
        factorial[0] = factorial[1] = 1;
        for (int i = 2; i <= N; i++) {
            factorial[i] = factorial[i - 1] * i % MOD;
        }
        return factorial;
    }

    static long pow(long num, int exp) {
        long result = 1L;
        while (exp > 0) {
            if ((exp & 1) == 1) result = result * num % MOD;
            num = num * num % MOD;
            exp >>= 1;
        }
        return result;
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
