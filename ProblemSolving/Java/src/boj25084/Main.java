package boj25084;

class Main {

    static final String PREFIX = "Case #";
    static final String SEPARATOR = ": ";
    static final double PI = 3.141592653589793;

    public static void main(String[] args) throws Exception {

        int T = read();
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {

            long area = 0;
            long R = read();
            int A = read();
            int B = read();

            while (R > 0) {
                area += R * R;
                R *= A;
                area += R * R;
                R /= B;
            }

            sb
                .append(PREFIX)
                .append(t)
                .append(SEPARATOR)
                .append(area * PI)
                .append('\n');

        }

        System.out.print(sb);

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
