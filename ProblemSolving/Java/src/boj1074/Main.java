package boj1074;

class Main {

    static int N, R, C, count;

    public static void main(String[] args) throws Exception {

        N = 1 << (read() - 1);
        R = read();
        C = read();

        Z(N, N);

        System.out.print(count);

    }

    static void Z(int r, int c) {

        if (N == 0) return;

        int square = N * N;
        int blocks = 0;
        N >>= 1;

        if (R < r) {
            r -= N;
        } else {
            r += N;
            blocks += square << 1;
        }

        if (C < c) {
            c -= N;
        } else {
            c += N;
            blocks += square;
        }

        count += blocks;
        Z(r, c);

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
