package boj17577;

class Main {

    private static int n, m, p[] = new int[1000];

    public static void main(String[] args) throws Exception {

        final StringBuilder sb = new StringBuilder();

        while (init()) {
            for (int j = 0; j < m; j++) for (int k = 0; k < n; k++) p[k] += read();

            int max = 0;
            for (int k = 0; k < n; k++) {
                max = max(max, p[k]);
                p[k] = 0;
            }

            sb.append(max).append('\n');
        }

        System.out.print(sb);

    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }

    private static boolean init() throws Exception {
        return (n = read()) + (m = read()) > 0 ? true : false;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
