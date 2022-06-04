package boj13116;

class Main {

    public static void main(String[] args) throws Exception {

        int T = read();
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {

            int A = read();
            int B = read();

            while (A != B) {

                if (A > B) {
                    A >>= 1;
                }

                if (B > A) {
                    B >>= 1;
                }

            }

            sb.append(A * 10).append('\n');

        }

        System.out.print(sb);

    }

    static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }

}
