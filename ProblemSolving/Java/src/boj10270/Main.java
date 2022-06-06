package boj10270;

class Main {

    static final long[] factorial = new long[100_001];
    static final int MOD = 1_000_000_007;
    static int last;

    public static void main(String[] args) throws Exception {

        StringBuilder sb = new StringBuilder();

        factorial[0] = factorial[1] = 1;
        factorial[2] = last = 2;

        int t = read();
        while (t-- > 0) sb.append(f(read()) - 1).append('\n');

        System.out.print(sb);

    }

    static long f(int n) {
        if (factorial[n] == 0) {
            for (int i = last + 1; i <= n; i++) {
                factorial[i] = factorial[i - 1] * i;
                factorial[i] %= MOD;
            }
            last = n;
        }
        return factorial[n];
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
