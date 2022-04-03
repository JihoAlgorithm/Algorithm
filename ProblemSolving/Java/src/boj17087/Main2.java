package boj17087;

class Main2 {

    public static void main(String[] args) throws Exception {

        int N = read();
        int K = read();
        int D = Math.abs(K - read());

        for (int i = 1; i < N; i++)
            D = gcd(D, Math.abs(K - read()));

        System.out.print(D);

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
