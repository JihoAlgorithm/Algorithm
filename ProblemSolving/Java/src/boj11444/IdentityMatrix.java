package boj11444;

class IdentityMatrix {

    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        long N = read();
        long[][] F = {{1, 0}, {0, 1}};
        long[][] A = {{1, 1}, {1, 0}};
        while (N > 0) {
            if ((N & 1) == 1) F = multiply(F, A);
            A = multiply(A, A);
            N >>= 1;
        }
        print(F[0][1]);
    }

    static void print(long num) throws Exception {
        int i = (int) Math.log10(num) + 1;
        char[] buffer = new char[i];
        while (num > 0) {
            buffer[--i] = (char) (num % 10 | 48);
            num /= 10;
        }
        java.io.BufferedWriter bw = new java.io.BufferedWriter(new java.io.OutputStreamWriter(System.out));
        bw.write(buffer);
        bw.close();
    }

    static long[][] multiply(long[][] a, long[][] b) {
        long[][] c = new long[2][2];
        c[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % MOD;
        c[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % MOD;
        c[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % MOD;
        c[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % MOD;
        return c;
    }

    static long read() throws Exception {
        int c;
        long n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
