package boj3036;

class Main {

    public static void main(String[] args) throws Exception {

        int N = read();
        int R = read();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < N; i++) {
            int r = read();
            int gcd = gcd(R, r);
            sb.append(R / gcd).append('/').append(r / gcd).append('\n');
        }

        System.out.print(sb);

    }

    static int gcd(int a, int b) {
        while (b > 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
