package boj6064;

class LCM {

    public static void main(String[] args) throws Exception {

        StringBuilder sb = new StringBuilder();

        for (int T = read(); T > 0; T--) {

            int M = read();
            int N = read();
            int x = read() - 1;
            int y = read() - 1;

            int max = lcm(M, N);
            int ans = -1;

            for (int k = x; k < max; k += M) {
                if (k % N == y) {
                    ans = k + 1;
                    break;
                }
            }

            sb.append(ans).append('\n');

        }

        System.out.print(sb);

    }

    static int lcm(int a, int b) {
        return a * b / gcd(a, b);
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
