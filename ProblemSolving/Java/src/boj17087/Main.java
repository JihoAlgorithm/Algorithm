package boj17087;

class Main {

    public static void main(String[] args) throws Exception {

        final int N = read();
        final int K = read();

        int gcd = read() - K;
        if (gcd < 0) gcd = ~gcd + 1;

        for (int i = 1; i < N; i++) {
            int diff = read() - K;
            if (diff < 0) diff = ~diff + 1;
            gcd = gcd(gcd, diff);
        }

        System.out.print(gcd);

    }

    static int gcd(int a, int b) {
        int r = a % b;
        if (r == 0) return b;
        return gcd(b, r);
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
