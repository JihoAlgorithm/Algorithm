package boj10093;

class Main {

    private static long A, B, diff;

    public static void main(String[] args) throws Exception {

        init();
        final StringBuilder sb = new StringBuilder().append(diff).append('\n');

        for (int i = 1; i <= diff; i++) sb.append(A + i).append(' ');

        System.out.print(sb);

    }

    private static void init() throws Exception {
        A = read();
        B = read();
        if (A > B) {
            diff = A;
            A = B;
            B = diff;
        }
        diff = A == B ? 0 : B - A - 1;
    }

    private static long read() throws Exception {
        long c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
